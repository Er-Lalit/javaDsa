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
    public ListNode[] splitListToParts(ListNode head, int k) {
        if(head==null)
        {
            return new ListNode[k];
        }
        ListNode[] arr=new ListNode[k];
        int len=length(head);
        int eachBuketNode=len/k;
        int extra=len%k;
        ListNode curr=head;
        ListNode prev=null;
        for(int i=0;curr!=null && i<k;i++)
        {
            arr[i]=curr;
            for(int j=0;j<eachBuketNode+(extra>0?1:0);j++)
            {
                prev=curr;
                curr=curr.next;
            }
            prev.next=null;
            extra--;
        }
        return arr;
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