/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int length=0;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
                length=findLength(head);
                break;
            }
        }
        if(length==0)
        {
            return null;
        }
        //find the start node 
        ListNode s=head;
        ListNode f=head;
        while(length>0)
        {
            s=s.next;
            length-=1;
        }
        //keep moving forword both and they will meet at cycle start
        while(f!=s)
        {
            s=s.next;
            f=f.next;
        }
        return s;
    }
    static int findLength(ListNode node)
    {
        ListNode f=node;
        ListNode s=node;
        int length=0;
        while(f!=null && f.next!=null)
        {
            f=f.next.next;
            s=s.next;
            if(s==f)
            {
                ListNode temp=s;
                do{
                    temp=temp.next;
                    length+=1;
                }
                while(s!=temp);
                break;

            }

        }
        return length;
    }

}