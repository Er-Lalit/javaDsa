class Solution {
    static int arr[][]=new int[23][23];
    public boolean predictTheWinner(int[] nums) {
        for(int k=0;k<arr.length;k++)
        {
          for(int l=0;l<arr[0].length;l++)
          {
            arr[k][l]=-1;
          }
        }     
        return findDiffer(0,nums.length-1,nums)>=0;


        //this was minmax game approach
        // int total=0;
        // for(int i:nums)
        // {
        //     total+=i;
        // }
        // int p1=solve(0,nums.length-1,nums);
        // int p2=total-p1;
        // if(p1>=p2)
        // {
        //     return true;
        // }
        // else
        // {
        //     return false;
        // }

        
    }
     
    //this method was for hte minmax approach question
    // static int solve(int i, int j,int nums[])
    // {
        
    //     if(i>j)
    //     {
    //         return 0;
    //     }
    //     if(i==j)
    //     {
    //         return nums[i];
    //     }
    //     if(arr[i][j]!=-1)
    //     {
    //         return arr[i][j];
    //     }
    //     // if we take i
    //     int takeI=nums[i]+Math.min(solve(i+2,j,nums),solve(i+1,j-1,nums));

    //     //if we take j
        
    //     int takeJ=nums[j]+Math.min(solve(i+1,j-1,nums),solve(i,j-2,nums));

    //     return arr[i][j]= Math.max(takeI,takeJ);
    // }
    //this is new finddiffernce approach
    static int findDiffer(int i,int j,int nums[])
    {
        if(i>j)
        {
            return 0;
        }
        if(i==j)
        {
            return nums[i];
        }
        if(arr[i][j]!=-1)
        {
            return arr[i][j];
        }
        
        // we take i now
        int takeI=nums[i]-findDiffer(i+1,j,nums);
        //we take j now
        int takeJ=nums[j]-findDiffer(i,j-1,nums);
        return arr[i][j]=Math.max(takeI,takeJ);
    }
}