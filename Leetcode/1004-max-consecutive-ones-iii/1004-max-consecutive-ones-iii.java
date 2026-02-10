class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans=0;
        int l=0;
        int r=0;
        int zero=k;
        while(r<nums.length)
        {
             if(nums[r]==0 )
            {
                zero--;
            }
            while(zero<0)
            {
                
                if(nums[l]==0)
                {
                    zero++;
                }
                l++;
            }
            if(zero!=-1)
            {
                int len=r-l+1;
                ans=Math.max(len,ans);
            }
            r++;
           
            
            

        }
       
        return ans;
    }
}