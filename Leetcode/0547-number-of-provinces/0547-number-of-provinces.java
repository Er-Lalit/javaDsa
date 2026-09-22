class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected[i].length;j++)
            {
                if(isConnected[i][j]==1)
                {
                    adj.get(i).add(j);
                }

            }
        }
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++)
        
        {
            if(visited[i]==false)
            {
                dfs(adj,i,visited);
                count++;

            }
        }
        return count;
        
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj,int u,boolean[] visited)
    {
        visited[u]=true;

        for(int v:adj.get(u))
        {
            if(!visited[v])
            {
                dfs(adj,v,visited);
            }
        }

    }
}