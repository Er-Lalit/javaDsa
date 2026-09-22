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
    static int count;
    public int averageOfSubtree(TreeNode root) {
        HashMap<TreeNode,Integer> h=new HashMap<>();
        height(root,h);

        count=0;

        checkAverage(root,h);

        return count;

        
    }
    static int checkAverage(TreeNode node,HashMap<TreeNode,Integer> h)
    {
        if(node==null)
        {
            return 0;
        }

        int left=checkAverage(node.left,h);
        int right=checkAverage(node.right,h);
        int sum=left+right+node.val;
        if(sum/h.get(node)==node.val)
        {
            count++;
        }
        return sum;

    }
    static int height(TreeNode node,HashMap<TreeNode,Integer> h)
    {
        if(node==null)
        {
            return 0;
        }

        int left=height(node.left,h);
        int right=height(node.right,h);
        int hgt=1+left+right;
        h.put(node,hgt);
        return hgt;

        
    }
}