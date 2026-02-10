class Solution {
    public void sortColors(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int idx=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[idx]){
                    idx=j;
                }
                     }
                int temp=nums[idx];
                nums[idx]=nums[i];
                nums[i]=temp;
           
        }
        
    }
}