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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list=new ArrayList();
        ListNode temp=head;
        int length=0;
        while(temp!=null)
        {
            list.add(temp.val);
            temp=temp.next;
            length++;
        }
        Stack<Integer> st=new Stack<>();
        int arr[]=new int[length];
        while(length>0)
        {
            while(!st.isEmpty() && st.peek()<=list.get(length-1))
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                arr[length-1]=0;
            }
            else
            {
                arr[length-1]=st.peek();
            }
            st.push(list.get(length-1));
            length--;
            
        }
        return arr;
        

        
    }
}