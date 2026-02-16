// User function Template for Java
class Solution {
    boolean check(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // code here
        int  mat[][]=new int[n][n];
        for(ArrayList<Integer> arr:edges)
        {
            int u=arr.get(0)-1;
            int v=arr.get(1)-1;
            mat[u][v]=1;
            mat[v][u]=1;
        }
        boolean visited[]=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(solve(i,mat,n,count,visited))
            {
                return true;
            }
        }
        return false;
    }
    static boolean solve(int node,int mat[][],int n,int count,boolean[] visited)
    {
        visited[node]=true;
        count++;
        if(count==n)
        {
            return true;
        }
        for(int j=0;j<mat[node].length;j++)
        {
            if(mat[node][j]==1 && !visited[j])
            {
                if(solve(j,mat,n,count,visited))
                {
                    return true;
                }
            }
        }
        visited[node]=false;
        count--;
        return false;
        
    }
}