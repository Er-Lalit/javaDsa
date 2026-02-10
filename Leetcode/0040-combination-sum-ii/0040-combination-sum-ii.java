class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList();
        Stack<Integer> st=new Stack();
        solve(candidates,st,ans,0,target);
        return ans;
        
    }
    static void solve(int arr[],Stack<Integer> st,List<List<Integer>> ans,int idx,int target)
    {

        //base case
        if(target==0)
        {
            ans.add(new ArrayList(st));
            return;
        }
        if(target<0)
        {
            return;
        }
        for(int i=idx;i<arr.length;i++)
        {
            // here we check if we have a same element which we have a previous then we don't repeate the same process agian to element the duplicate
            if(i>idx && arr[i]==arr[i-1])
            {
                continue;
            }
            st.push(arr[i]);

            solve(arr,st,ans,i+1,target-arr[i]);

            st.pop();



        }
    }
}