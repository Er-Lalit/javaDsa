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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
        {
            return head;
        }
        int len=findLen(head);
        if(n>len)
        {
            return head ;
        }
        int skip=len-n;
        ListNode prev=null;
        ListNode current=head;
        for(int i=0;current!=null && i<skip ;i++)
        {
            prev=current;
            current=current.next;
        }
        if(prev==null)
        {
            head=head.next;
            return head;
        }
        prev.next=current.next;
        return head;

        
    }
    static int findLen(ListNode node)
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