class Solution {
    public int splitArray(int[] nums, int k) {
        int start=0;
        int end=0;
        for(int i=0;i<nums.length;i++)
        {
            start=Math.max(start,nums[i]);
            end+=nums[i];

        }
        int ans=0;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(check(mid,k,nums))
            {
                ans=mid;
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return ans;
    }
        static boolean check(int mid ,int k,int nums[])
        {
            int sum=0;
            int count=1;
            for(int i=0;i<nums.length;i++)
            {
                if(sum+nums[i]<=mid)
                {
                    sum+=nums[i];
                }
                else
                {
                    count++;
                    sum=nums[i];
                }
            }
            return count<=k;

        }
        
    
}