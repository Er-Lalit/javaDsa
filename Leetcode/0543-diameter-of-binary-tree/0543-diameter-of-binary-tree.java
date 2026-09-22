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
    static int dia;
    public int diameterOfBinaryTree(TreeNode root) {
        dia=Integer.MIN_VALUE;

        helper(root);

        return dia;
        
    }
    static int helper(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }

        int left=helper(node.left);

        int right=helper(node.right);

        int diameter=left+right;

        dia=Math.max(dia,diameter);

        return Math.max(left,right)+1;
    }


}