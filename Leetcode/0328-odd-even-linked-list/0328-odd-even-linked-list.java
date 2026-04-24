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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode oddDummy=new ListNode(0);
        ListNode oPrev=oddDummy;
      
        ListNode evenDummy=new ListNode(0);
        ListNode ePrev=evenDummy;
        ListNode temp=head;
        int idx=1;
        while(temp!=null)
        {
            if(idx%2!=0)
            {
                oPrev.next=temp;
                oPrev=temp;
                temp=temp.next;
            }
            else
            {
                ePrev.next=temp;
                ePrev=temp;
                temp=temp.next;
            }
            idx++;
        }

        oPrev.next=evenDummy.next;
        ePrev.next=null;
        return oddDummy.next;

    

        
    }
}