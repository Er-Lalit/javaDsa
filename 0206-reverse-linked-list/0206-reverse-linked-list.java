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
    static ListNode head1;
    public ListNode reverseList(ListNode head) {
        head1=head;
        recu(head);
        return head1;

        
        
    }
    static ListNode recu(ListNode node)
    {
        if(node==null || node.next==null)
        {
            head1=node;
            return node;
        }
        ListNode newNode=recu(node.next);
        newNode.next=node;
        node.next=null;
        return node;
    }
}