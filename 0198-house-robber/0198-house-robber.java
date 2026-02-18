class Solution {
   static int arr[];
    public int rob(int[] nums) {
        arr=new int[nums.length];
        Arrays.fill(arr,-1);
        return solve(nums,0);
        
    }
    static int solve(int [] nums,int idx)
    {
        if(idx>=nums.length)
        {
            return 0;
        }
        if(arr[idx]!=-1)
        {
            return arr[idx];
        }

        int f=0;
        int s=0;
        f=nums[idx]+solve(nums,idx+2);
        s=solve(nums,idx+1);
        return arr[idx]=Math.max(f,s);
        
    }
}