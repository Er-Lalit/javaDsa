class Solution {
   static int arr[];
    public int rob(int[] nums) {
        // arr=new int[nums.length];
        // Arrays.fill(arr,-1);
        // return solve(nums,0);
        if(nums.length==1)
        {
            return nums[0];
        }
        int arr[]=new int[nums.length+1];
        arr[0]=0;
        arr[1]=nums[0];
        return solve(nums,arr);
        
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
    // bottom up aaproach
    static int solve(int nums[],int arr[])
    {
        for(int i=2;i<=nums.length;i++)
        {
            int steal=nums[i-1]+arr[i-2];
            int skip=arr[i-1];
            arr[i]=Math.max(steal,skip);
        }
        return arr[nums.length];
    }
}