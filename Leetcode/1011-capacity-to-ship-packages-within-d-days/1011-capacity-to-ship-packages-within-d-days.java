class Solution {
    public int shipWithinDays(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(max,nums[i]);
        }
        int lb=max;
        int ub=sum;
        int ans=0;
        while(lb<=ub){
            int mid=(lb+ub)/2;
            if(isPossible(mid,k,nums)==true){
                ub=mid-1;
                ans=mid;


            }
            else{
                lb=mid+1;
            }
        }
        return ans;
    }
    static boolean isPossible(int mid,int k, int [] nums){
        int sum=0;
        int count=1;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                sum=nums[i];
                count++;
            }


        }
        return count<=k;
    }
}