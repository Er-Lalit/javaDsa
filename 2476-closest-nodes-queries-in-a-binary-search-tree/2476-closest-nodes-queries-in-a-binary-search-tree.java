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
 //** this is the simple approach 
// class Solution {
//     public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
//         List<List<Integer>> ans=new ArrayList<>();
       
//         for(int i=0;i<queries.size();i++)
//         {
//             List<Integer> temp=new ArrayList<>();
//             temp.add(lSmallerEqual(root,-1,queries.get(i)));
//             temp.add(sGreaterEqual(root,-1,queries.get(i)));
//             ans.add(temp);         
//         }
//         return ans;
        
//     }
//     static int lSmallerEqual(TreeNode node,int ans,int querie)
//     {
//         if(node==null)
//         {
//             return ans;
//         }
//         if(node.val==querie)
//         {
//             return node.val;
//         }
//         if(node.val>querie)
//         {
//             return lSmallerEqual(node.left,ans,querie);
//         }
//         else
//         {
//             return lSmallerEqual(node.right,node.val,querie);
//         }
//     }
//     static int sGreaterEqual(TreeNode node,int ans, int querie)
//     {
//         if(node==null)
//         {
//             return ans;
//         }
//         if(node.val==querie)
//         {
//             return node.val;
//         }
//         if(node.val<querie)
//         {
//             return sGreaterEqual( node.right, ans, querie);
//         }
//         else
//         {
//            return  sGreaterEqual(node.left,node.val,querie);
//         }
//     }
// }

// here we can do this using the inorder traversal 

class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<queries.size();i++)
        {
            List<Integer> temp=new ArrayList<>();
            temp.add(floor(queries.get(i),list));
            temp.add(ceil(queries.get(i),list));
            ans.add(temp);

        }
        return ans;

    }
    static void inorder(TreeNode node,List<Integer> list)
    {
        if(node==null)
        {
            return ;
        }
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }
    static int floor(int val,List<Integer> list)
    {
        int lb=0;
        int ub=list.size()-1;
        int ans=-1;
        while(lb<=ub)
        {
            int mid=(lb+ub)/2;
            if(list.get(mid)==val)
            {
                return val;
            }
            else if(list.get(mid)>val)
            {
                ub=mid-1;
            }
            else
            {
                ans=list.get(mid);
                lb=mid+1;
            }
        }
        return ans;
    }
    static int ceil(int val,List<Integer> list)
    {
        int lb=0;
        int ub=list.size()-1;
        int ans=-1;
        while(lb<=ub)
        {
            int mid=(lb+ub)/2;
            if(list.get(mid)==val)
            {
                return val;
            }
            else if(list.get(mid)<val)
            {
                lb=mid+1;
            }
            else
            {
                ans=list.get(mid);
                ub=mid-1;
            }
        }
        return ans;
    }
}    