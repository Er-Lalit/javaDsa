class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        List<List<Integer>> adj=new ArrayList();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList());
        }
        
        for(int edge[]:edges)
        {
            int u=edge[0];
            int v=edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int color[]=new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++)
        {
            if(color[i]==-1 && dfs(i,color,adj,1)==false)
            {
                return false;
            }
        }
        return true;
    }
    static boolean dfs(int curr,int color[],List<List<Integer>> adj,int currColor)
    {
        color[curr]=currColor;
        
        for(int v: adj.get(curr))
        {
            if(color[v]==currColor)
            {
                return false;
            }
            if((color[v]==-1) && dfs(v,color,adj,1-currColor)==false)
            {
                return false;
            }
        }
        return true;
        
    }
}
