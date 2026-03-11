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
    public int getDecimalValue(ListNode head) {
        ListNode node=reverse(head);
        int value=0;
        int i=0;
        while(node!=null)
        {
            value=(node.val*(int)Math.pow(2,i))+value;
            i++;
            node=node.next;

        }
        return value;
        
    }
    static ListNode reverse(ListNode node)
    {
        if(node==null && node.next==null)
        {
            return node;
        }
        ListNode prev=null;
        ListNode current=node;
        ListNode nxt=current.next;
        while(current!=null)
        {
            current.next=prev;
            prev=current;
            current=nxt;
            if(nxt!=null)
            {
                nxt=nxt.next;
            }
        }
        return prev;

    }
}