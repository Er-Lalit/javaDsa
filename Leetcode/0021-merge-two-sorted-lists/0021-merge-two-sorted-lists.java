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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head=null;
        ListNode temp=head;
        while(list1!=null && list2!=null)
        {
            if(list1.val<=list2.val)
            {
                // if this is the first node
                if(head==null)
                {
                    head=list1;
                    list1=list1.next;
                    temp=head;
                }
                else
                {
                    temp.next=list1;
                    temp=temp.next;
                    list1=list1.next;
                }
            }
            else
            {
                if(head==null)
                {
                    head=list2;
                    list2=list2.next;
                    temp=head;
                }
                else
                {
                    temp.next=list2;
                    temp=temp.next;
                    list2=list2.next;
                }
            }
        }
 
        // attach remaining nodes
        if(list1 != null) 
        {
          if(head == null) head = list1; // if head was null, assign it
          else temp.next = list1;
        }

        if(list2 != null)
        {
          if(head == null) head = list2; // if head was null, assign it
          else temp.next = list2;
        }
        return head;
        
    }
}