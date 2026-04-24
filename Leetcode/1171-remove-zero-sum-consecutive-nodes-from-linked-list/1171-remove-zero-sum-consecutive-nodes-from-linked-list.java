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
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head==null)
        {
            return head;
        }
        if(head==null && head.val==0)
        {
            return null;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode temp=head;
        int prefixSum=0;

        HashMap<Integer,ListNode> map=new HashMap();
        map.put(0,dummy);

        while(temp!=null)
        {
            prefixSum+=temp.val;
            if(map.containsKey(prefixSum))
            {
                ListNode start=map.get(prefixSum);
                int tempSum=prefixSum;
                ListNode tempStart=start;
                while(tempStart.next!=temp)
                {
                    tempSum+=tempStart.next.val;
                    map.remove(tempSum);
                    tempStart=tempStart.next;
                }
                start.next=temp.next;


            }
            else 
            {
                map.put(prefixSum,temp);
            }
            temp=temp.next;
        }
        return dummy.next;
        
    }
}