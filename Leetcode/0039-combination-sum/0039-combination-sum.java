import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Stack<Integer> st=new Stack<>();
        List<List<Integer>> ans=new ArrayList<>();
        Set<List<Integer>> set=new HashSet<>();
        backtrack(0,candidates,st,ans,target,set);
        return ans;

    }

    static void backtrack(int i, int arr[],Stack<Integer> st,List<List<Integer>> ans,int target,Set<List<Integer>> set)
    {
        if(i==arr.length ||target<0){
            return ;
        }
        if(target==0)
        {
            if(!set.contains(new ArrayList<>(st))){
            ans.add(new ArrayList<>(st));
            set.add(new ArrayList<>(st));
            }
            return ;
        }
        st.push(arr[i]);
        backtrack(i+1,arr,st,ans,target-arr[i],set);
        backtrack(i,arr,st,ans,target-arr[i],set);
        st.pop();
        backtrack(i+1,arr,st,ans,target,set);

    }
}
