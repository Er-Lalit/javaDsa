class LRUCache {
    Node head;
    Node tail;
    int size;
    HashMap<Integer,Node> map;
    private class Node{
        int val;
        int key;
        Node next;
        Node prev;
        Node(int val,int key)
        {
            this.val=val;
            this.key=key;
        }
    }

    public LRUCache(int capacity) {
        size=capacity;
        map=new HashMap();
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }
        Node node=map.get(key);
        if(node==head)
        {
            return node.val;
        }
        if(node.prev!=null)
        {
            node.prev.next=node.next;
        }
        if(node.next!=null)
        {
            node.next.prev=node.prev;
        }
        else
        {
            tail=node.prev;
        }
        // put at the head
        node.next=head;
        node.prev=null;
        head.prev=node;
        head=node;

            
        return node.val;
        
        
    }

    public void put(int key, int value) {
        if(head==null)
        {
            Node node=new Node(value,key);
            head=node;
            tail=node;
            map.put(key,node);
            size--;
            return ;
        }
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            node.val=value;
            if(node==head)
            {
                return ;
            }
            //detech node
            if(node.prev!=null)
            {
                node.prev.next=node.next;
            }
            if(node.next!=null)
            {
                node.next.prev=node.prev;
            }
            else 
            {
                tail=node.prev;
            }
            //move to head;
            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;

            return;
        }
        
        Node node=new Node(value,key);
        if(size==0)
        {
            // remove form tail
            map.remove(tail.key);
            if(tail.prev!=null)
            {
                tail=tail.prev;
            
                tail.next=null;
            }   
            else
            {
                tail=null;
                head=null;
            } 
        }
        else
        {
            size--;
        }
        // insertion at head
        node.next=head;
        if(head!=null)
        {
            head.prev=node;

        }
        node.prev=null;
        head=node;
        if(tail==null)
        {
            tail=node;
        }
        map.put(key,node);
       
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */