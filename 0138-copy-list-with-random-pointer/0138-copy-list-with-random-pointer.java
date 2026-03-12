/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
        {
            return null;
        }
        HashMap<Node,Node> map=new HashMap();
        Node newHead=null;
        Node curr=head;
        Node prev=null;
        while(curr!=null)
        {
            Node node=new Node(curr.val);
            map.put(curr,node);
            if(newHead==null)
            { 
                newHead=node;
                prev=node;

            }
            else
            {
                prev.next=node;
                prev=node;
            }
           
            curr=curr.next;
            
        }
        // fill random pointer
        curr=head;
        Node newCurr=newHead;
        while(curr!=null)
        {
            if(curr.random!=null)
            {
                newCurr.random=map.get(curr.random);
            }
            curr=curr.next;
            newCurr=newCurr.next;
        }
        return newHead;
        
    }
}