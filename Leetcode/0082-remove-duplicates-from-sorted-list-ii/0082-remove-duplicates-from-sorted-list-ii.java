/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 // this was the brut force approach 
//class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         if(head==null || head.next==null)
//         {
//             return head;
//         }
//        HashMap<Integer,Integer> map=new HashMap();
//        ListNode curr=head;
//        while(curr!=null)
//        {
//           if(!map.containsKey(curr.val))
//           {
//             map.put(curr.val,1);
//           }
//           else
//           {
//             int valInKey=map.get(curr.val);
//             map.put(curr.val,valInKey+1);

//           }
//           curr=curr.next;
//         }
//         // if here one val in each node 

//         if(map.size()==1)
//         {
//             return null;
//         }
//         curr=head;
//         ListNode prev=null;
//         while(curr!=null)
//         {
//             if(prev==null && map.get(curr.val)<2)
//             {
//                 head=curr;
//                 prev=curr;
//                 curr=curr.next;
//                 continue;
//             }
//             if(map.get(curr.val)<2)
//             {
//                 prev.next=curr;
//                 prev=curr;
//                 curr=curr.next;
//             }
//             else
//             {
//                 curr=curr.next;
//             }

//         }
//         if(prev==null)
//         {
//             return null;
//         }
//         prev.next=null;
//         return head;
        
//     }
// }
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curr=head;
        while(curr!=null)
        {
            if(curr.next!=null && curr.val==curr.next.val)
            {
                while(curr.next!=null && curr.val ==curr.next.val)
                {
                    curr=curr.next;
                }
                prev.next=curr.next;
            }
            else
            {
                prev=prev.next;
            }
            curr=curr.next;
        }
        return dummy.next;

    }
}    