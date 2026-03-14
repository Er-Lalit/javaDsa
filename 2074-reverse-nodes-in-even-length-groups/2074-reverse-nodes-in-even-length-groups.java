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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode temp=head;
        int group=1;
        int remainLen=length(head);
        ListNode last=null;

        while(temp!=null)
        {
            if(group%2!=0 && remainLen>=group)
            {
                // do skip 
                for(int i=0;i<group;i++)
                {
                    last=temp;
                    temp=temp.next;
                }
                remainLen-=group;
            }
            else if(group%2==0 && remainLen>=group)
            {
                ListNode prev=null;
                ListNode curr=temp;
                ListNode nxt=temp.next;
                ListNode newEnd=temp;
                int tGroup=group;
                while(tGroup>0 && curr!=null)
                {
                    curr.next=prev;
                    prev=curr;
                    curr=nxt;
                    if(nxt!=null)
                    {
                        nxt=nxt.next;

                    }
                    tGroup--;
                }
                newEnd.next=curr;
                last.next=prev;
                last=newEnd;
                temp=last.next;
                remainLen-=group;

            }
            else if(remainLen%2!=0)
            {
                // do skip 
                for(int i=0;i<group && temp!=null;i++)
                {
                    last=temp;
                    temp=temp.next;
                }
                remainLen-=group;

            }
            else
            {
                ListNode prev=null;
                ListNode curr=temp;
                ListNode nxt=temp.next;
                ListNode newEnd=temp;
                int tGroup=group;
                while(curr!=null)
                {
                    curr.next=prev;
                    prev=curr;
                    curr=nxt;
                    if(nxt!=null)
                    {
                        nxt=nxt.next;

                    }
                }
                newEnd.next=curr;
                last.next=prev;
                last=newEnd;
                temp=last.next;
                remainLen-=group;

            }
            group++;

        }
        return head;
        
    }
    static int length(ListNode node)
    {
        int count=0;
        while(node!=null)
        {
            count++;
            node=node.next;
        }
        return count;
    }
}