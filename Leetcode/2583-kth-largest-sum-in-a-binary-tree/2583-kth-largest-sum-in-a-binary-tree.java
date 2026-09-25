/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q=new ArrayDeque();
        PriorityQueue<Long> pq=new PriorityQueue(Comparator.reverseOrder());
        q.offer(root);
        while(!q.isEmpty())
        {
            int len=q.size();
            long sum=0;
            for(int i=0;i<len;i++)
            {
                TreeNode node=q.poll();
                sum+=node.val;
                if(node.left!=null)
                {
                    q.offer(node.left);
                }
                if(node.right!=null)
                {
                    q.offer(node.right);
                }
            }
            pq.offer(sum);
        }
        if(k>pq.size())
        {
            return -1;
        }
        long ans=0;
        for(int i=0;i<k;i++)
        {
            ans=pq.poll();

        }
        return ans;
        
    }
    
}