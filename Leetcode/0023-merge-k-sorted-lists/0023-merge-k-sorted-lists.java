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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<1)
        {
            return null;
        }
        if(lists.length==1)
        {
            return lists[0];
        }
        
    
            ListNode ans=merge(lists[0],lists[1]);
            for(int i=2;i<lists.length;i++)
            {
                ans=merge(ans,lists[i]);
            }
    
        return ans;
    }
    static ListNode merge(ListNode l1,ListNode l2)
    {
        ListNode ans=null;
        ListNode temp=null;
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                if(ans==null)
                {
                    ans=l1;
                    temp=l1;
                    l1=l1.next;
                    temp.next=null;
                    continue;
                }
                temp.next=l1;
                l1=l1.next;
                temp=temp.next;
                temp.next=null;
            }
            else
            {
                if(ans==null)
                {
                    ans=l2;
                    temp=l2;
                    l2=l2.next;
                    temp.next=null;
                    continue;
                }
                temp.next=l2;
                temp=temp.next;
                l2=l2.next;
                temp.next=null;
            }
            
        }
        if(l1!=null)
        {
            if(temp==null)
            {
                ans=l1;
            }
            else
            {
                temp.next=l1;
            }    
        }
        if(l2!=null)
        {
            if(temp==null)
            {
                ans=l2;
            }
            else
            {
                temp.next=l2;
            }
            
        }
        return ans;
    }
}