/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=findLen(headA);
        int lenB=findLen(headB);
        while(lenA<lenB)
        {
            headB=headB.next;
            lenB--;
        }
        while(lenB<lenA)
        {
            headA=headA.next;
            lenA--;
        }
        while(headA!=null && headB!=null)
        {
            if(headA==headB)
            {
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
        
    }
    static int findLen(ListNode node)
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