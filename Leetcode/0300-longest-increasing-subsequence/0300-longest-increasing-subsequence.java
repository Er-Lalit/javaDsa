class Solution {
    static int arr[][];
    public int lengthOfLIS(int[] nums) {
       arr=new int[nums.length+1][nums.length+1];
       for(int i=0;i<arr.length;i++)
       {
        Arrays.fill(arr[i],-1);
       }
        Stack<Integer> st=new Stack();
        return solve(-1,nums,0);
        
        
    }
    static int solve(int p,int nums[],int i)
    {
        
        if(i==nums.length)
        {
            
            return 0;
        }
        if(arr[i][p+1]!=-1)
        {
            return arr[i][p+1];

        }
       
        int take=0;
        int skip=0;
        // when we take
        if(p==-1 || nums[i]>nums[p])
        {
        take=1+solve(i,nums,i+1);
        }
        skip=solve(p,nums,i+1);
        return arr[i][p+1]=Math.max(take,skip);
    }
   
}