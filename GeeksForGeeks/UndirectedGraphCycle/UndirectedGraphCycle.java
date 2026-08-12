package GeeksForGeeks.UndirectedGraphCycle;

import java.util.ArrayList;

public class UndirectedGraphCycle {

    // cycle detection using the dfs

//     class Solution {
//     public boolean isCycle(int V, int[][] edges) {
//        ArrayList<ArrayList<Integer>> adj=new ArrayList();
//        for(int i=0;i<V;i++)
//        {
//            adj.add(new ArrayList());
//        }
       
//        for(int[] edge:edges)
//        {
//            int u=edge[0];
//            int v=edge[1];
//            adj.get(u).add(v);
//            adj.get(v).add(u);
//        }
       
//        boolean visited[]=new boolean[V];
       
//        for(int i=0;i<V;i++)
//        {
//            if(!visited[i] && isCycleDfs(adj,i,visited,-1))
//            {
//                return true;
//            }
//        }
//        return false;
        
//     }
//     static boolean isCycleDfs(ArrayList<ArrayList<Integer>> adj,int u,boolean visited[],int parent)
//     {
//         visited[u]=true;
//         for(int v:adj.get(u))
//         {
//             if(v==parent)
//             {
//                 continue;
//             }
            
//             if(visited[v])
//             {
//                 return true;
//             }
//             if(isCycleDfs(adj,v,visited,u))
//             {
//                 return true;
//             }
//         }
//         return false;
        
//     }
// }

// **** cycle detection using the bfs *** 

class Solution {
    public boolean isCycle(int V, int[][] edges) {
       ArrayList<ArrayList<Integer>> adj=new ArrayList();
       for(int i=0;i<V;i++)
       {
           adj.add(new ArrayList());
       }
       
       for(int[] edge:edges)
       {
           int u=edge[0];
           int v=edge[1];
           adj.get(u).add(v);
           adj.get(v).add(u);
       }
       
       boolean visited[]=new boolean[V];
       
       for(int i=0;i<V;i++)
       {
           if(!visited[i] && isCycleBfs(adj,i,visited))
           {
               return true;
           }
       }
       return false;
        
    }
    static boolean isCycleBfs(ArrayList<ArrayList<Integer>> adj,int u,boolean visited[])
    {
        visited[u]=true;
        Queue<ArrayList<Integer>> q=new ArrayDeque();
        q.offer(new ArrayList<>(Arrays.asList(u,-1)));
        while(!q.isEmpty())
        {
            ArrayList<Integer> list=q.poll();
            int source=list.get(0);
            int parent=list.get(1);
            for(int v:adj.get(source))
            {
                if(visited[v]==false)
                {
                    visited[v]=true;
                    q.offer(new ArrayList<>(Arrays.asList(v,source)));
                    
                }
                else if(v!=parent)
                {
                    return true;
                }
            }
           
        }
        return false;
    }
}
    
}
