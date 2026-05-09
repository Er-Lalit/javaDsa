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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode();
        ListNode temp=dummy;
        int carry=0;
        while(l1!=null && l2!=null)
        {
            int num=l1.val+l2.val+carry;
            int digit=num%10;
            carry=num/10;
            ListNode node=new ListNode(digit);
            temp.next=node;
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;
            

        }
        while(l1!=null)
        {
            int num=l1.val+carry;
            int digit=num%10;
            carry=num/10;
            ListNode node=new ListNode(digit);
            temp.next=node;
            temp=temp.next;
            l1=l1.next;
        }
        while(l2!=null)
        {
            int num=l2.val+carry;
            int digit=num%10;
            carry=num/10;
            ListNode node=new ListNode(digit);
            temp.next=node;
            temp=temp.next;
            l2=l2.next;
        }
        if(carry!=0)
        {
            ListNode node=new ListNode(carry);
            temp.next=node;
        }
        return dummy.next;
        
    }
}