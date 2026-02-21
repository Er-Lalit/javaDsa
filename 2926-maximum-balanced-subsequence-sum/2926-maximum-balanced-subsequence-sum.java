class Solution {
    public long maxBalancedSubsequenceSum(int[] nums)
    {
        TreeMap<Long,Long> map=new TreeMap<>();
        long result=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            long key=(long)nums[i]-i;

            //find the previous best sum
            Map.Entry<Long,Long> entry=map.floorEntry(key);

            long sum=nums[i];
            if(entry!=null)
            {
                sum = Math.max(nums[i], nums[i] + entry.getValue());

            }
            
            // update value in map
            if(!map.containsKey(key)|| map.get(key)<sum)
            {
                map.put(key,sum);
            }
            sum=map.get(key);
            
            // remove unless larger key which is which sum is smaller than the current key
            while(true)
            {
                Map.Entry<Long,Long> higher=map.higherEntry(key);
                if(higher==null || higher.getValue()>sum) break;
                map.remove(higher.getKey());
            }
            result=Math.max(result,sum);
        }
        return  result;

    }

    
//     also this is can't work for the this problem because this is the also give the tle 
//     static long max;
//     public long maxBalancedSubsequenceSum(int[] nums)
//     {
//         long maxelement=Long.MIN_VALUE;
//         for(int i=0;i<nums.length;i++)
//         {
//            maxelement=Math.max(maxelement,nums[i]);
//         }
//        if(maxelement<=0)
//         {
//            return maxelement;
//         }
//         long arr[]=new long[nums.length];
//         for(int i=0;i<nums.length;i++)
//         {
//             arr[i]=nums[i];
//         }
//         max=Long.MIN_VALUE;
//         return solve( arr,nums);



//     }
//     static long solve(long arr[],int nums[])
//     {
      
//         for(int i=1;i<nums.length;i++)
//         {
//             for(int j=0;j<i;j++)
//             {
//                if(nums[i]-nums[j]>=i-j)
//                 {
//                    arr[i]=Math.max(arr[i],nums[i]+arr[j]);
//                    max=Math.max(max,arr[i]);
//                 }   
//             }
            
//         }
//         return max;
//     }
// }

    
    // this is how i am start to approach this problem 
    // static long[][][] dp;
    // public long maxBalancedSubsequenceSum(int[] nums) {
        
    //     // dp=new long[nums.length+1][nums.length+1][2];
    //     // for(int i=0;i<dp.length;i++)
    //     // {
    //     //     for(int j=0;j<dp[i].length;j++)
    //     //     {
    //     //         Arrays.fill(dp[i][j],-1);
    //     //     }
    //     // }
    //     // if(nums.length==1)
    //     // {
    //     //     return nums[0];
    //     // }
    //     // // if(nums.length==2)
    //     // // {
    //     // //     return Math.max(nums[0],nums[1]);
    //     // // }
    //     // return solve(0,-1,nums,0);
        
    // }
    // static long solve(int idx,int p,int nums[],int taken)
    // {
    //     if(idx==nums.length)
    //     {
    //         if(taken==1)
    //         {
    //             return 0;
    //         } 
    //         return Integer.MIN_VALUE;
    //     }
    //     if(dp[idx][p+1][taken]!=-1)
    //     {
    //         return dp[idx][p+1][taken];
    //     }
    //     // take 
    //     long take=Integer.MIN_VALUE;
    //     if(p==-1 || nums[idx]-nums[p]>=idx-p)
    //     {
    //         take=nums[idx]+solve(idx+1,idx,nums,1);

    //     }
    //     //skip 
    //     long skip=solve(idx+1,p,nums,taken);
    //     return dp[idx][p+1][taken]=Math.max(take,skip);
    // }

    // ***** then i am reach at this stage and then i am thing that with the o(n^2) the solution is not possible so i need to go with the bottom up approach only so i am use then bottom up approach 

    //  static long arr[][];
    // public long maxBalancedSubsequenceSum(int[] nums)
    // {

    //     arr=new long[nums.length+1][nums.length+1];
    //     for(int i=0;i<arr.length;i++)
    //     {
    //         Arrays.fill(arr[i],-1);
    //     }
    //     long maxelement=Long.MIN_VALUE;
    //     for(int i=0;i<nums.length;i++)
    //     {
    //         maxelement=Math.max(maxelement,nums[i]);
    //     }
    //     if(maxelement<=0)
    //     {
    //         return maxelement;
    //     }

    //     return solve(0,-1,nums);


    // }
    // static long solve(int idx,int p,int nums[])
    // {
    //     if(idx>=nums.length)
    //     {
    //         return 0;
    //     }
    //     if(arr[idx][p+1]!=-1)
    //     {
    //         return arr[idx][p+1];
    //     }
    //     long take=Long.MIN_VALUE;
    //     long skip=Long.MIN_VALUE;
    //     if(p==-1 || nums[idx]-nums[p]>=idx-p)
    //     {
    //         take=nums[idx]+solve(idx+1,idx,nums);

    //     }
    //     skip=solve(idx+1,p,nums);
    //     return arr[idx][p+1]=Math.max(take,skip);

    // }
}    

