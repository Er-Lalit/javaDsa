class Solution {
    public int[] runningSum(int[] nums) {
        int[] running=new int[nums.length];
        int count=0;
        for(int i=0;i<nums.length;i++){
            count=count+nums[i];
            running[i]=count;

        }
        return running;
        
    }
}