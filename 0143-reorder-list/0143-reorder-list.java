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
    public void reorderList(ListNode head) {
        if(head==null && head.next==null)
        {
            return ;
        }  
        ListNode mid=findMid(head);   
        ListNode hs=reverse(mid);
        ListNode hf=head;
        while(hf!=null && hs!=null)
        {
            ListNode temp=hf.next;
            hf.next=hs;
            hf=temp;
            ListNode temp1=hs.next;
            hs.next=hf;
            hs=temp1;
        } 
        if(hf!=null)
        {
            hf.next=null;
        }
    }
    static ListNode findMid(ListNode node)
    {
        ListNode f=node;
        ListNode s=node;
        while(f!=null && f.next!=null)
        {
            f=f.next.next;
            s=s.next;
        }
        return s;

    }
    static ListNode reverse(ListNode node)
    {
        ListNode prev=null;
        ListNode present=node;
        ListNode nxt=present.next;
        while (present!=null) {
            present.next=prev;
            prev=present;
            present=nxt;
            if(nxt!=null)
            {
                nxt=nxt.next;

            }
        }
        return prev;
    }
}