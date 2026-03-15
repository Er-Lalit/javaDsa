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
// class Solution {
//     List<Integer> list;
    
//     public Solution(ListNode head) {
//         list=new ArrayList<>();
//         ListNode temp=head;
//         while(temp!=null)
//         {
//             list.add(temp.val);
//             temp=temp.next;
//         }
        
        
        
//     }
    
//     public int getRandom() {
//         int len=list.size();
//         int idx=(int)(Math.random()*len)%len;
//        return list.get(idx);
       
        
//     }
// Reservoir Sampling 
class Solution {
    ListNode Head;
    public Solution(ListNode head) {
        Head=head;
    }
    public int getRandom() {
        ListNode temp=Head;
        int ans=0;
        int count=1;
        while(temp!=null)
        {
            if((Math.random()%count)<1.0/count)
            {
                ans=temp.val;

            }
            count++;
            temp=temp.next;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */