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
// this was the o(n) space complexity 
// class Solution {
//     public Node copyRandomList(Node head) {
//         if(head==null)
//         {
//             return null;
//         }
//         HashMap<Node,Node> map=new HashMap();
//         Node newHead=null;
//         Node curr=head;
//         Node prev=null;
//         while(curr!=null)
//         {
//             Node node=new Node(curr.val);
//             map.put(curr,node);
//             if(newHead==null)
//             { 
//                 newHead=node;
//                 prev=node;

//             }
//             else
//             {
//                 prev.next=node;
//                 prev=node;
//             }
           
//             curr=curr.next;
            
//         }
//         // fill random pointer
//         curr=head;
//         Node newCurr=newHead;
//         while(curr!=null)
//         {
//             if(curr.random!=null)
//             {
//                 newCurr.random=map.get(curr.random);
//             }
//             curr=curr.next;
//             newCurr=newCurr.next;
//         }
//         return newHead;
        
//     }
// }
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
        {
            return null;
        }
        Node curr=head;
        // here we create a new node and also put in the same linkedList 

        while(curr!=null)
        {
            Node node=new Node(curr.val);
            Node nxt=curr.next;
            curr.next=node;
            node.next=nxt;
            curr=nxt;
        }
        // manage random pointer
        curr=head;
        while(curr!=null && curr.next!=null)
        {
            if(curr.random!=null)
            {
                curr.next.random=curr.random.next;   
            }
            curr=curr.next.next;
        }
        // seperare the new list
        Node newHead=head.next;
        Node newCurr=newHead;
        curr=head;
        while(curr!=null && newCurr!=null)
        {
            curr.next=curr.next==null?null:curr.next.next;
            newCurr.next=newCurr.next==null?null:newCurr.next.next;
            curr=curr.next;
            newCurr=newCurr.next;
        }
        return newHead;


    }
}           