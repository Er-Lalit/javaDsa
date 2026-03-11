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
    public ListNode rotateRight(ListNode head, int k) {
        if(k<1 || head==null || head.next==null)
        {
            return head;
        }
        ListNode last=head;
        int length=1;
        while(last.next!=null)
        {
            length+=1;
            last=last.next;
        }
        int rotation=k%length;
        int skip=length-rotation;
        ListNode newLast=head;
        for(int i=0;i<skip-1;i++)
        {
            newLast=newLast.next;
        }
        last.next=head;
        head=newLast.next;
        newLast.next=null;
        return head;
        
    }
    
}