class Solution {
    static int parent[];
    static int rank[];
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
        {
            return -1;
        }
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
        int component=n;
        for(int arr[]:connections)
        {
            int x=arr[0];
            int y=arr[1];

            int xParent=find(x);
            int yParent=find(y);

            if(xParent!=yParent)
            {
                union(xParent,yParent);
                component--;
            }
        }
        return component-1;
        
    }
    static int find(int x)
    {
        if(parent[x]==x)
        {
            return x;
        }
        return parent[x]=find(parent[x]);
    }

    static void union(int x, int y)
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