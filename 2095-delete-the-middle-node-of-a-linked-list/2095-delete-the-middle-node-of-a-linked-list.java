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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null)
        {
            return head;
        }
        ListNode prev=null;
        ListNode s=head;
        ListNode f=head;
        while(f!=null && f.next!=null)
        {
            prev=s;
            s=s.next;
            f=f.next.next;
        }
        if(prev==null)
        {
            return null;
        }
        prev.next=s.next;
        return head;
        
    }
}