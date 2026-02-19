class Solution {
    static long arr[][];
    public long maxAlternatingSum(int[] nums) {
        arr=new long[nums.length+1][2];
        for(int i=0;i<nums.length;i++)
        {
            Arrays.fill(arr[i],-1);

        }
        
        return solve(nums,0,1);
    }
    static long solve(int nums[],int i,int parity)
    {
        if(i>=nums.length)
        {
            return 0;
        }
        if(arr[i][parity]!=-1)
        {
            return arr[i][parity];
        }
        // we skip
        long skip=solve(nums,i+1,parity);

        // we take 
        long take=0;
        if(parity==1)
        {
            take=nums[i]+solve(nums,i+1,0);
        }
        else
        {
            take=-nums[i]+solve(nums,i+1,1);
        }
        return arr[i][parity]=Math.max(take,skip);
        


    }    
}