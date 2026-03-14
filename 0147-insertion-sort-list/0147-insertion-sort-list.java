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
    public ListNode insertionSortList(ListNode head) {
        if(head==null && head.next==null)
        {
            return head;
        }
        ListNode sortedHead=head;
        ListNode tail=head;
        head=head.next;
        while(head!=null)
        {
            if(head.val>=tail.val)
            {
                head=head.next;
                tail=tail.next;
            }
            else
            {
                tail.next=head.next;
                ListNode temp=sortedHead;
                ListNode prev=null;
                while(temp!=tail && head.val>=temp.val )
                {
                    prev=temp;
                    temp=temp.next;
                }
                if(prev==null)
                {
                    head.next=sortedHead;
                    sortedHead=head;
                }
                else
                {
                    prev.next=head;
                    head.next=temp;
                }
                head=tail.next;

            }
        }
        return sortedHead;

        
    }
}