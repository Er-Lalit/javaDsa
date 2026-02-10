class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int[] prefix=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int result=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int frequency=binarySearch(i,prefix,nums,k);
            result=Math.max(result,frequency);
        }
    
        return result;
    }
    static int binarySearch(int targetIndex, int []prefix,int nums[],int k){
       int  lb=0;
       int  ub=targetIndex;
        int resultIndex=-1;
        int target=nums[targetIndex];
        while(lb<=ub){
            int mid=(lb+ub)/2;
            int count=targetIndex-mid+1;
            int windowSum=count*target;
            int originalSum=prefix[targetIndex]-prefix[mid]+nums[mid];
            int ops=windowSum-originalSum;
            if(ops>k){
                lb=mid+1;
            }else{
                resultIndex=mid;
                ub=mid-1;
            }
        }
        return targetIndex-resultIndex+1;
    }
}