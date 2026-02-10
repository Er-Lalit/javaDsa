class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Stack<Integer> temp=new Stack<>();
        backtrack(nums,0,temp,result);
        return result;
        
    }
    public static void backtrack(int[] nums,int idx,Stack<Integer> temp,List<List<Integer>> result){
        if(idx==nums.length)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.push(nums[idx]);
        backtrack(nums,idx+1,temp,result);
        temp.pop();
        backtrack(nums,idx+1,temp,result);

    }
}