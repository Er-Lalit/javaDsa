class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList();
        Stack<Integer> st=new Stack();
        solve(ans,st,1,k,n);
        return ans;
        
    }
    static void solve(List<List<Integer>> ans,Stack<Integer> st,int idx,int k,int target)
    {
        if(k==0 && target==0)
        {
            ans.add(new ArrayList(st));
            return;

        }
        if(k<0 || target<0)
        {
            return;
        }
        for(int i=idx;i<=9;i++)
        {
            st.push(i);
            solve(ans,st,i+1,k-1,target-i);
            st.pop();

        }

    }
}