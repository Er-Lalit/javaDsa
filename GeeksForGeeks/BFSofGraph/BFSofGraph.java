package GeeksForGeeks.BFSofGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSofGraph {
    class Solution {
    static ArrayList<Integer> result;
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Map<Integer,List<Integer>> mp=new HashMap();
        for(int u=0;u<adj.size();u++)
        {
            List<Integer> ls=new ArrayList();
            for(int v:adj.get(u))
            {
                ls.add(v);
            }
            mp.put(u,ls);
        }
        
        result=new ArrayList();
        
        boolean visited[]=new boolean[adj.size()];
        
        bsf(mp, visited, 0);
        
        return result;
        
    }
    
    static void bsf(Map<Integer,List<Integer>> mp,boolean visited[],int u)
    {
        if(visited[u]==true)
        {
            return;
        }
        result.add(u);
        visited[u]=true;
        Queue<Integer> q=new ArrayDeque();
        q.offer(u);
        while(!q.isEmpty())
        {
            int v=q.poll();
            for(int i:mp.get(v))
            {
                if(!visited[i])
                {
                    q.offer(i);
                    visited[i]=true;
                    result.add(i);
                }
            }
        }
    }
}
}
