/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        storeParent(root,map);
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(target);
        Set<TreeNode> visited=new HashSet<>();
        visited.add(target);
        while(!q.isEmpty())
        {
            if(k==0)
            {
                break;
            }
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                if(node.left!=null && !visited.contains(node.left))
                {
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right))
                {
                    q.offer(node.right);
                    visited.add(node.right);
                }
                if(map.containsKey(node)&& !visited.contains(map.get(node)))
                {
                    q.offer(map.get(node));
                    visited.add(map.get(node));
                }
            }
            k--;
        }

        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            TreeNode node=q.poll();
            ans.add(node.val);
        }
        return ans;
        
    }

    // for store the parent of the nodes we create here this method 
    static void storeParent(TreeNode node,HashMap<TreeNode,TreeNode> map)
    {
        if(node==null)
        {
            return;
        }
        if(node.left!=null)
        {
            map.put(node.left,node);
        }
        storeParent(node.left,map);
        if(node.right!=null)
        {
            map.put(node.right,node);
        }
        storeParent(node.right,map);
    }
}