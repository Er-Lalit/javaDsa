class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        for(int i:nums)
        {
            ls.add(i);
        }
        backtrack(ls,0,ans);
        return ans;
    }
    static void backtrack(List<Integer> ls,int idx,List<List<Integer>> ans)
    {
        if(idx==ls.size())
        {
            ans.add(new ArrayList(ls));
            return;
            
        }
        for(int i=idx;i<ls.size();i++)
        {
            swap(idx, i, ls);
            backtrack(ls, idx+1,ans);
            swap(idx, i, ls);

        }
    }
    static void swap(int a,int b,List<Integer> ls)
    {
        int temp=ls.get(a);
        ls.set(a,ls.get(b));
        ls.set(b,temp);

    }
}