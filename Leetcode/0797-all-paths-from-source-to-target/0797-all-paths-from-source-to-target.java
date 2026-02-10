class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Stack<Integer> st=new Stack<>();
        List<List<Integer>> ans=new ArrayList<>();
        st.push(0);
        backtrack(ans,st,graph,0,graph.length);
        return ans;
        
    }

   static void backtrack(List<List<Integer>> ans,Stack<Integer> st,int graph[][],int idx,int n)
    {
        if(idx==n-1)
        {
            ans.add(new ArrayList(st));
        }
        
        
        for(int j=0;j<graph[idx].length;j++)
        {
            st.push(graph[idx][j]);
            backtrack(ans, st, graph, graph[idx][j], n);
            st.pop();
                
        }

        
    }    




}