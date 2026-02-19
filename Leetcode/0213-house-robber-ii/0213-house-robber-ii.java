class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
        int arr[]=new int[nums.length+1];
        Arrays.fill(arr,-1);
        int n=nums.length;
        int takeF=solve(0,nums,arr,n-1);
        Arrays.fill(arr,-1);
        int takeL=solve(1,nums,arr,n);
        return Math.max(takeF,takeL);
        
    }
    // recursive+memoization approach
    int solve(int idx,int nums[],int arr[],int n)
    {
        if(idx>=n)
        {
            return 0;
        }
        if(arr[idx]!=-1)
        {
            return arr[idx];
        }
        int steal=nums[idx]+solve(idx+2,nums,arr,n);
        int skip=solve(idx+1,nums,arr,n);
        return arr[idx]=Math.max(steal,skip);
    }
}