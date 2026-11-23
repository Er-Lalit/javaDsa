class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> adj=new ArrayList();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList());
        }

        for(int arr[]:times)
        {
            int u=arr[0];
            int v=arr[1];
            int w=arr[2];

            adj.get(u).add(new int[]{v,w});
        }

        int distance[]=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[k]=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[]{0,k});

        while(!pq.isEmpty())
        {
            int arr[]=pq.poll();
            int time=arr[0];
            int node=arr[1];

            if(time>distance[node]) continue;

            for(int edge[]:adj.get(node))
            {
                int v=edge[0];
                int d=edge[1];
                if(distance[v]>time+d)
                {
                    distance[v]=time+d;

                    pq.offer(new int[]{time+d,v});

                }
            }

            
        }
        int ans=0;
        for(int i=1;i<=n;i++)
        {
            ans=Math.max(distance[i],ans);

        }
        if(ans==Integer.MAX_VALUE || ans==0)
        {
            return -1;
        }
        return ans;

        
    }
}