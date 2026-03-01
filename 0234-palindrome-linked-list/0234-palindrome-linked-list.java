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
    public boolean isPalindrome(ListNode head) {
        ListNode mid=findMid(head);
        ListNode secondHead=reverseList(mid);
        while(head!=null && secondHead!=null)
        {
            if(head.val!=secondHead.val)
            {
                return false;
            }
            head=head.next;
            secondHead=secondHead.next;
        }
        return true;
        
    } 
    static ListNode reverseList(ListNode node)
    {
        ListNode prev=null;
        ListNode present=node;
        ListNode nxt=node.next;
        while(present!=null)
        {
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
    static ListNode findMid(ListNode node)
    {
        ListNode f=node;
        ListNode s=node;
        while(f!=null && f.next!=null)
        {
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
}