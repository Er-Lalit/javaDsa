class Solution {
    public int rob(int[] nums) {
        //this code is for recursion+memoization 
        // if(nums.length==1)
        // {
        //     return nums[0];
        // }
        // int arr[]=new int[nums.length+1];
        // Arrays.fill(arr,-1);
        // int n=nums.length;
        // int takeF=solve(0,nums,arr,n-1);
        // Arrays.fill(arr,-1);
        // int takeL=solve(1,nums,arr,n);
        // return Math.max(takeF,takeL);

        // this is for the bottom up approach
        if(nums.length==1)
        {
            return nums[0];
        }
        if(nums.length==2)
        {
            return Math.max(nums[0],nums[1]);
        }
        int n=nums.length;
        int arr[]=new int[n+1];
        int takeF=solve(1,nums,arr,n);
        Arrays.fill(arr,0);
        int takeS=solve(0,nums,arr,n-1);
        return Math.max(takeF,takeS);
        
    }
    // recursive+memoization approach
    // int solve(int idx,int nums[],int arr[],int n)
    // {
    //     if(idx>=n)
    //     {
    //         return 0;
    //     }
    //     if(arr[idx]!=-1)
    //     {
    //         return arr[idx];
    //     }
    //     int steal=nums[idx]+solve(idx+2,nums,arr,n);
    //     int skip=solve(idx+1,nums,arr,n);
    //     return arr[idx]=Math.max(steal,skip);
    // }
    // this is the bottom up approach 
    static int solve(int i,int nums[],int arr[],int n)
    {
        // if(n==1)
        // {
        //     return nums[i];
        // }
        // if(n==2)
        // {
        //     return Math.max(nums[i],nums[i+1]);
        // }
        arr[i]=0;
        arr[i+1]=nums[i];
        for(int j=i+2;j<=n;j++)
        {
            int steal=nums[j-1]+arr[j-2];
            int skip=arr[j-1];
            arr[j]=Math.max(steal,skip);

        }
        return arr[n];


    }
}
