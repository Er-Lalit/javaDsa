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
        if(l1==null)
        {
            return l2;
        }
        if(l2==null)
        {
            return l1;
        }
        ListNode hF=reverseList(l1);
        ListNode hS=reverseList(l2);
        ListNode ansHead=null;
        int sum=0;
        int carry=0;
        while(hF!=null && hS!=null)
        {
            int a1=hF.val;
            int a2=hS.val;
           
            sum = a1 + a2 + carry;

            int digit = sum % 10;
            carry = sum / 10;

            ListNode node = new ListNode(digit);
            node.next = ansHead;
            ansHead = node;
            hF=hF.next;
            hS=hS.next;
            
        }
        while(hF!=null)
        {
            sum=hF.val+carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode node = new ListNode(digit);
            node.next = ansHead;
            ansHead = node;
            hF=hF.next;
        }
        while(hS!=null)
        {
            sum=hS.val+carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode node = new ListNode(digit);
            node.next = ansHead;
            ansHead = node;
            hS=hS.next;
        }
        if(carry>0)
        {
            ListNode node=new ListNode(carry);
            node.next=ansHead;
            ansHead=node;
        }
        return ansHead;



        
    }
    static ListNode reverseList(ListNode node)
    {
        ListNode prev=null;
        ListNode current=node;
        ListNode nxt=node.next;
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