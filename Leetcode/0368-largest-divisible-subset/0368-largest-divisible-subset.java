class Solution {
   
    public List<Integer> largestDivisibleSubset(int[] nums)
    {
        Arrays.sort(nums);
        int dp[]=new int[nums.length];
        int prevInd[]=new int[nums.length];
        int maxLen=1;
        int maxInd=0;
        Arrays.fill(dp,1);
        Arrays.fill(prevInd,-1);
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                
                if(nums[i]%nums[j]==0)
                {
                    if(dp[i]<dp[j]+1)
                    {
                        dp[i]=dp[j]+1;
                        prevInd[i]=j;
                    }
                    if(dp[i]>maxLen)
                    {
                        maxLen=dp[i];
                        maxInd=i;
                    }
                }
            }
        }
        Stack<Integer> ans=new Stack();
        while(maxInd!=-1)
        {
            ans.push(nums[maxInd]);
            maxInd=prevInd[maxInd];

        }
        return ans;

    }

 // this is the recursive approach and this  is not work here   
//    static List<Integer> ans;
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         ans=new ArrayList<>();
//         Arrays.sort(nums);
//         Stack<Integer> st=new Stack();
        
//         solve(st,nums,0,-1);
//         return ans;
        
//     }
//     static void solve(Stack<Integer> st,int nums[],int idx,int p)
    
//     {
//         if(idx==nums.length)
//         {
//             if(st.size()>ans.size())
//             {
//                 ans=new ArrayList(st);
//             }
//             return ;
//         }
//         //take
//         if(p==-1 || nums[idx]%nums[p]==0)
//         {
//             st.push(nums[idx]);
//             solve(st,nums,idx+1,idx);
//             st.pop();
//         }
//         // not take
//         solve(st,nums,idx+1,p);

//     }
}