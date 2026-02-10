class Solution {
    public int splitArray(int[] nums, int k) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(max,nums[i]);
        }
        int lb=max;
        int ub=sum;
        int ans=-1;
        while(lb<=ub){
            int mid=(lb+ub)/2;
            if(isPossible(nums,k,mid)){
                ans=mid;
                ub=mid-1;

            }
            else{
                lb=mid+1;
            }
        }
        return ans;
        
    }
    static boolean isPossible(int nums[],int k,int mid){
        int count=1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                count++;
                sum=nums[i];
            }
        }
        return count<=k;
    }
}