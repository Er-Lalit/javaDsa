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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(list1==null && list2==null)
        {
            return null;
        }
        ListNode tail=list2;
        while(tail.next!=null)
        {
            tail=tail.next;
        }
        ListNode prev=null;
        ListNode temp=list1;
        int count1=a;
        while(count1>0 && temp!=null)
        {
            prev=temp;
            temp=temp.next;
            count1--;

        }
        prev.next=list2;
        int count=b-a+1;
        while(count>0 && temp!=null)
        {
            prev=temp;
            temp=temp.next;
            count--;
        }
        tail.next=prev.next;
       // prev.next=null;
        return list1;
        
    }
}