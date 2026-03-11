class MyLinkedList {
    private Node head;
    private Node tail;
  

    private class Node{
         private int val;
    private Node next;
        Node(int val)
        {
            this.val=val;
            next=null;
        }
    }

    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if(head==null || index<0)
        {
            return -1;
        }
        Node temp=head;
        int idx=0;
        while(temp!=null)
        {
            if(index==idx)
            {
                return temp.val;
            }
            else
            {
                idx++;
                temp=temp.next;
            }
        }
        return -1;        
    }
    
    public void addAtHead(int val) {
        if(head==null)
        {
            Node node=new Node(val);
            head=node;
            tail=node;
            return ;
        }
        Node node=new Node(val);
        node.next=head;
        head=node;
        
    }
    
    public void addAtTail(int val) {
        if(head==null)
        {
            Node node=new Node(val);
            head=node;
            tail=node;
            return ;
        }
        Node node=new Node(val);
        tail.next=node;
        tail=node;
        
    }
    
    public void addAtIndex(int index, int val) {
        if(head==null)
        {
            if(index==0)
            {
                addAtHead(val);

            }
            
            return ;
        }
        if(index==0)
        {
            
            addAtHead(val);
            return ;

        }
        int len=findLen(head);
        if(index>len)
        {
            return ;
        }
        Node prev=null;
        Node temp=head;
        for(int i=0;temp!=null && i<index;i++)
        {
            prev=temp;
            temp=temp.next;
        }
        Node node=new Node(val);
        prev.next=node;
        node.next=temp;
        if(temp==null)
        {
            tail=node;
        }
    }
    
    public void deleteAtIndex(int index) {
        
        if(head==null || index<0)
        {
            return ;
        }
        if(index==0)
        {
            head=head.next;
            return;
        }
        Node temp=head;
        Node prev=null;
        for(int i=0;temp!=null && i<index;i++)
        {
            prev=temp;
            temp=temp.next;
        }
        if(temp==null)
        {
            return ;
        }
        prev.next=temp.next;
        if(tail==temp)
        {
            tail=prev;
        }

        
    }
    static int findLen(Node node)
    {
        int count=0;
        while(node!=null)
        {
            count++;
            node=node.next;

        }
        return count;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */