class Solution {
    static int parent[];
    static int rank[];
    public boolean equationsPossible(String[] equations) {
        parent=new int[26];
        rank=new int[26];
        for(int i=0;i<26;i++)
        {
            parent[i]=i;
        }

        for(String s:equations)
        {
            if(s.charAt(1)=='=')
            {
                union(s.charAt(0)-'a',s.charAt(3)-'a');
            }
            
        }
        for(String s:equations)
        {
            if(s.charAt(1)=='!')
            {
                int f=find(s.charAt(0)-'a');
                int se=find(s.charAt(3)-'a');
                if(f==se)
                {
                    return false;
                }
            }
        }
        return true;

        
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