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
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=curr.next;
        while(curr!=null)
        {
            ListNode newEnd=curr;
            ListNode last=prev;
            for(int i=0;curr!=null && i<2;i++){
                curr.next=prev;
                prev=curr;
                curr=next;
                if(next!=null)
                {
                    next=next.next;
                }
            }
            if(last!=null)
            {
                last.next=prev;
            }
            else 
            {
                head=prev;
            }
            newEnd.next=curr;
            prev=newEnd;
        }
        return head;
        
    }
}