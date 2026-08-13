package GeeksForGeeks.Topological_Sort;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    // *** topological sort using the dfs

    class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];
            
            adj.get(u).add(v);
        }
        
        boolean visited[]=new boolean[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                Dfs(adj,st,visited,i);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
       while(!st.isEmpty())
       {
           ans.add(st.pop());
       }
        return ans;
        
    }
    static void Dfs(ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,boolean visited[],int u)
    {
        visited[u]=true;
        
        for(int v:adj.get(u))
        {
            if(!visited[v])
            {
                Dfs(adj,st,visited,v);
            }
        }
        st.push(u);
    }
}
    
}
