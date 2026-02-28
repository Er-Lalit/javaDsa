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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode mid=findMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return mergeList(left,right);
        
    }
    static ListNode findMid(ListNode head)
    {
        ListNode prev=null;
        ListNode s=head;
        ListNode f=head;
        while(f!=null && f.next!=null)
        {
            prev=s;
            s=s.next;
            f=f.next.next;
        }
        prev.next=null;
        return s;
    }
    static ListNode mergeList(ListNode list1,ListNode list2)
    {
        ListNode head=null;
        ListNode temp=head;
        while(list1!=null && list2!=null)
        {
            if(list1.val<=list2.val)
            {
                if(head==null)
                {
                    head=list1;
                    temp=list1;
                    list1=list1.next;
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
                    temp=list2;
                    list2=list2.next;
                }
                else
                {
                    temp.next=list2;
                    temp=temp.next;
                    list2=list2.next;
                }
            }
        }
        if(list1!=null)
        {
            if(head==null)
            {
                head=list1;
            }
            else
            {
                temp.next=list1;
            }
        }
        if(list2!=null)
        {
            if(head==null)
            {
                head=list2;
            }
            else
            {
                temp.next=list2;
            }
        }
        return head;
    }
}