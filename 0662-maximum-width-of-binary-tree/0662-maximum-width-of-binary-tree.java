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
 
class pair{
    TreeNode node;
    long index;
    pair(TreeNode node,long index)
    {
        this.node=node;
        this.index=index;
    }
} 
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        long max=Long.MIN_VALUE;
        Deque<pair> q=new ArrayDeque<>();
        q.offer(new pair(root,0));
        while(!q.isEmpty())
        {
            int n=q.size();
            long l=q.peekFirst().index;
            long r=q.peekLast().index;
            max=Math.max(max,r-l+1);
            while(n-->0)
            {
                pair p=q.pollFirst();
                TreeNode node=p.node;
                long index=p.index;
                if(node.left!=null)
                {
                    q.offer(new pair(node.left,index*2+1));
                }
                if(node.right!=null)
                {
                    q.offer(new pair(node.right,index*2+2));
                }
            }
        }
        return (int)max;
        
    }
}