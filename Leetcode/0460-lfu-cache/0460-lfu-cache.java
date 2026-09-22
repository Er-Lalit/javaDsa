class LFUCache {

    class Node
    {
        int key;
        int value;
        int freq;
        Node next;
        Node prev;

        Node(int key,int value)
        {
            this.key=key;
            this.value=value;
            freq=1;
        }


    }

    class DoublyLinkedList
    {
        Node head;
        Node tail;
        int size;

        DoublyLinkedList()
        {
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
            size=0;
        }
        void addNode(Node node)
        {
            Node nextNode=head.next;

            node.next=nextNode;
            node.prev=head;
            head.next=node;
            nextNode.prev=node;

            size++;
        }
        void removeNode(Node node)
        {
            Node nextNode=node.next;
            Node prevNode=node.prev;

            prevNode.next=nextNode;
            nextNode.prev=prevNode;

            size--;
        }
        Node removeLast() {

            if (size > 0) {

                Node node = tail.prev;
                removeNode(node);

                return node;
            }

            return null;
        }
    }
    int capacity;
    int minFreq;

    HashMap<Integer,Node> chache;
    HashMap<Integer,DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        minFreq=0;
        chache=new HashMap<>();
        freqMap=new HashMap<>();
        
    }
    
    public int get(int key) {
        if(!chache.containsKey(key))
        {
            return -1;
        }
        Node node=chache.get(key);

        update(node);

        return node.value;
        
    }
    
    public void put(int key, int value) {
        if(chache.containsKey(key))
        {
            Node node=chache.get(key);

            node.value=value;

            update(node);

        }
        else
        {
            if(chache.size()==capacity)
            {
                DoublyLinkedList list=freqMap.get(minFreq);
                Node nodeToRemove=list.removeLast();
                chache.remove(nodeToRemove.key);
            }
            Node newNode =new Node(key,value);
            minFreq=1;
            DoublyLinkedList list = freqMap.getOrDefault(1, new DoublyLinkedList());
            list.addNode(newNode);
            freqMap.put(1,list);
            chache.put(key,newNode);
            
        }
        
    }
    private void update(Node node) {

        int currFreq = node.freq;

        DoublyLinkedList currList = freqMap.get(currFreq);

        currList.removeNode(node);

        if (currFreq == minFreq && currList.size == 0) {
            minFreq++;
        }

        node.freq++;

        DoublyLinkedList newList = freqMap.getOrDefault(node.freq, new DoublyLinkedList());

        newList.addNode(node);

        freqMap.put(node.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */