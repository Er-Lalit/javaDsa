class Solution {
    static int parent[];
    static int rank[];
    public long countPairs(int n, int[][] edges) {
        rank=new int[n];
        parent=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
        for(int arr[]:edges)
        {
            int x=arr[0];
            int y=arr[1];
            
            int xParent=find(x);
            int yParent=find(y);

            if(xParent!=yParent)
            {
                union(xParent,yParent);
            }
        }
        HashMap<Integer,Integer> map=new HashMap<>();
for (int i = 0; i < n; i++) {
    int root = find(i);

    map.put(root, map.getOrDefault(root, 0) + 1);
}
        long ans=0;

        for(int key:map.keySet())
        {
            int compSize=map.get(key);
            ans+=(long)compSize *(n-compSize);

            n-=compSize;
        }      
        return ans;  
    }
    static int find(int x)
    {
        if(parent[x]==x)
        {
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    static void union(int x,int y)
    {
        int xParent=find(x);
        int yParent=find(y);

        if(xParent==yParent)
        {
            return ;
        }

        if(rank[xParent]<rank[yParent])
        {
            parent[xParent]=yParent;
        }
        else if(rank[xParent]>rank[yParent])
        {
            parent[yParent]=xParent;
        }
        else
        {
            parent[xParent]=yParent;
            rank[yParent]++;
        }
    }
}