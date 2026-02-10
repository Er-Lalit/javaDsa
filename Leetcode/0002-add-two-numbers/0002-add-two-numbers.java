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
        ListNode current=dummy;
        int var1=0;
        int var2=0;
        int carry=0;
        int value=0;
        ListNode temp1=l1;
        ListNode temp2=l2;
        while(temp1  !=null || temp2!=null || carry!=0 ){
            var1=0;
            var2=0;
            if(temp1 !=null ){
                var1=temp1.val;
                temp1=temp1.next;
            }
            if(temp2 !=null ){
                var2=temp2.val;
                temp2=temp2.next;
            }
            int sum=var1+var2+carry;
            value=sum%10;
            carry=sum/10;

            ListNode newNode=new ListNode(value);
            current.next=newNode;
            current=current.next;
              
        }
       return dummy.next;
        
    }
}