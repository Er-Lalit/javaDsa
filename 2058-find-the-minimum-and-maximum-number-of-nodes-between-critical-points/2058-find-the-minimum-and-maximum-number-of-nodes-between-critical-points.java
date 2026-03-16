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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null || head.next==null|| head.next.next==null)
        {
            return new int[]{-1,-1};
        }
        List<Integer> list=new ArrayList();
        int size=1;
        ListNode prev=null;
        ListNode curr=head;
        ListNode nxt=head.next;
        while(curr!=null)
        {
            if(prev!=null && nxt!=null && ((curr.val>prev.val)&&(curr.val>nxt.val)))
            {
                list.add(size);
            }
            if(prev!=null && nxt!=null && ( (curr.val<prev.val) && (curr.val<nxt.val) )  )
            {
                list.add(size);
            }
            prev=curr;
            curr=nxt;
            if(nxt!=null)
            {
                nxt=nxt.next;
            }
            size++;
            
        }
        if(list.size()<2)
        {
            return new int[]{-1,-1};
        }
        int max=-1;
        int min=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++)
        {
            min=Math.min(min,list.get(i)-list.get(i-1));

        }
        max=Math.max(max,list.get(list.size()-1)-list.get(0));
        return new int[]{min,max};

        
    }
}