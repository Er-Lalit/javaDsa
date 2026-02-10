class Solution {
    public int findTargetSumWays(int[] nums, int target) {
      return  solve(nums,0,0,target);
        
    }
    static int solve(int arr[],int idx,int currentSum,int target){
        if(idx==arr.length)
        {
            if(currentSum==target)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        int plus=solve(arr,idx+1,currentSum+arr[idx],target);
        int minus=solve(arr,idx+1,currentSum-arr[idx],target);
        return plus+minus;

    }
}