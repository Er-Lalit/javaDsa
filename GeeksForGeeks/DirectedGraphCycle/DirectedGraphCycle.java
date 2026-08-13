package GeeksForGeeks.DirectedGraphCycle;

import java.util.ArrayList;

class DirectedGraphCyle{

    // ** this is the using the Dfs


    class Solution {
    public boolean isCyclic(int V, int[][] edges) {
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       for(int i=0;i<V;i++)
       {
           adj.add(new ArrayList());
       }
       
       for(int[] edge:edges)
       {
           int u=edge[0];
           int v=edge[1];
           
           adj.get(u).add(v);
       }
       
        boolean visited[]=new boolean[V];
        boolean inRecursion[]=new boolean[V];
        for(int u=0;u<V;u++)
        {
            if(!visited[u] && isCycleDfs(adj,visited,inRecursion,u))
            {
                return true;
            }
            
        }
        return false;
    }
    static boolean isCycleDfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],boolean inRecursion[],int u)
    {
        visited[u]=true;
        inRecursion[u]=true;
        for(int v:adj.get(u))
        {
            if(!visited[v] && isCycleDfs(adj,visited,inRecursion,v))
            {
                return true;
            }
            else if(inRecursion[v])
            {
                return true;
            }
        }
        inRecursion[u]=false;
        return false;
    }
}
}
