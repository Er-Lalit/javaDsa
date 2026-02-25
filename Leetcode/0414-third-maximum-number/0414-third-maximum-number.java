class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        long max=Long.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--)
        {
            if(max>nums[i])
            {
                count+=1;
                max=nums[i];
                if(count==3)
                {
                    return nums[i];
                }
            }

        }
        return nums[nums.length-1];
        
    }
}