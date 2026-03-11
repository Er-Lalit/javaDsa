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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null)
        {
            return head;
        }
        int len=findLen(head);
        if(len<k)
        {
            return head;
        }
        ListNode fK=head;
        for(int i=1;i<k;i++)
        {
            fK=fK.next;
        }
        int nodeLast=len-k;
        ListNode lK=head;
        for(int i=0;i<nodeLast;i++)
        {
            lK=lK.next;
        }
        int value=fK.val;
        fK.val=lK.val;
        lK.val=value;
        return head;
        
    }
    static int findLen(ListNode node)
    {
        int count=0;
        while(node!=null)
        {
            node=node.next;
            count++;
        }
        return count;
    }
}