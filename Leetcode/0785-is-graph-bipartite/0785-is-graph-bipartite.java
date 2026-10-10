class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[]=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++)
        {
            if(color[i]==-1 && !Bfs(i,1,color,graph))
            {
                return false; 
            }

        }
        return true;
        
    }

    public static boolean Bfs(int curr,int currCol,int color[],int graph[][])
    {
        Queue<Integer> q=new ArrayDeque<>();
        color[curr]=currCol;
        q.offer(curr);
        while(!q.isEmpty())
        {
            int u=q.poll();
            for(int v:graph[u])
            {
                if(color[v]==color[u])
                {
                    return false;
                }
                if(color[v]==-1)
                {
                    color[v]=1-color[u];
                    q.offer(v);
                }
            }
        }
        return true;
    }
}