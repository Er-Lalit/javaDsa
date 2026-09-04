class Solution {
    static List<List<Integer>> adj;
    static boolean visited[];
    static Stack<Integer> st;

    static boolean inRecursion[];
    public int[] findOrder(int c, int[][] p) {
        adj=new ArrayList<>();
        for(int i=0;i<c;i++)
        {
            adj.add(new ArrayList());
        }

        for(int v[]:p)
        {
            int a=v[0];
            int b=v[1];
            adj.get(b).add(a);
        }
        visited=new boolean[c];
        inRecursion=new boolean[c];
        st=new Stack<>();
        for(int i=0;i<c;i++)
        {
            if(!visited[i] && isCycle(i))
            {
                return new int[]{};
            }
        }
        int ans[]=new int[c];
        int i=0;
        while(!st.isEmpty())
        {
            ans[i]=st.pop();
            i++;
        }
        return ans;

        
    }
    static boolean isCycle(int u)
    {
        visited[u]=true;
        inRecursion[u]=true;
        for(int v:adj.get(u))
        {
            if(!visited[v] && isCycle(v))
            {
                return true;
            }
            else if(inRecursion[v])
            {
                return true;
            }
        }
        inRecursion[u]=false;
        st.push(u);
        return false;
    }
}