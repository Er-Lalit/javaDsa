class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
         int lb=0;
        int ub=nums.length-1;
        int ans=Integer.MAX_VALUE;
        while(lb<=ub){ 
             int mid=(lb+ub)/2;
            if(nums[mid]==nums[lb] && nums[mid]==nums[ub]){
                ans=Math.min(ans,nums[mid]);
                lb++;
                ub--;
                continue;
            }
           
            if(nums[lb]<=nums[mid]){
               ans= Math.min(nums[lb],ans);
                lb=mid+1;

            }
            else{
                // if(nums[mid]<=nums[ub]){
                    ans=Math.min(nums[mid],ans);
                    ub=mid-1;
                // }

            }
        }
        return ans;
        
    }
}