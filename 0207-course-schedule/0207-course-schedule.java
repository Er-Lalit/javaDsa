class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        int inDegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            adj.get(b).add(a);
            inDegree[a]+=1;
        }

        Queue<Integer> q=new ArrayDeque<>();
        int count=0;
        for(int i=0;i<inDegree.length;i++)
        {
            if(inDegree[i]==0)
            {
                q.offer(i);
                count++;
            }
        }
        while(!q.isEmpty())
        {
          int u=q.poll();
          for(int v:adj.get(u))
          {
            inDegree[v]--;
            if(inDegree[v]==0)
            {
                q.offer(v);
                count++;
            }
          }
        }
        return count==numCourses;

        
    }
}