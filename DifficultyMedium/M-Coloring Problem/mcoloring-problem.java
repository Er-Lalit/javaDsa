class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        int mat[][]=new int[v][v];
        for(int ar[]:edges)
        {
            int i=ar[0];
            int j=ar[1];
            mat[i][j]=1;
            mat[j][i]=1;
        }
        int color[]=new int[v];
        return solve(0,color,mat,v,m);
        
    }
    static boolean solve(int node,int[] color,int graph[][],int N,int m)
    {
        if(node==N)
        {
            return true;
        }
        for(int i=1;i<=m;i++)
        {
            if(isSafe(node, i, N,graph,color))
            {
                color[node]=i;
                if(solve(node+1, color, graph, N, m)) return true;
                color[node]=0;
            }
        }
        return false;
    }
    static boolean isSafe(int node,int col,int n,int graph[][],int[] color)
    {
        for(int i=0;i<n;i++)
        {
            if(graph[node][i]==1 && color[i]==col)
            {
                return false;
            }
        }
        return true;
        
    }
}