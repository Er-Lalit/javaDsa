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
    static int max;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        max=Integer.MIN_VALUE;
        solve(root);
        return max;
        
    }
    static int solve(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }
        int left=solve(node.left);
        int right=solve(node.right);
        int leftPath=0;
        int rightPath=0;

        if(node.left!=null && node.left.val==node.val)
        {
           leftPath=left+1;
        
        }
        if(node.right!=null && node.right.val==node.val)
        {
            rightPath=right+1;
        }
        max=Math.max(max,leftPath+rightPath);
        return Math.max(leftPath,rightPath);
    }

}