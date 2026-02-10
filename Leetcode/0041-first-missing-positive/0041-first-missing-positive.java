class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
       // when we have a answer range from 1 to n+1 then we can use the number as a index 
       // firstly we can visit 
       for(int i=0;i<nums.length;i++){
        if(nums[i]<=0 || nums[i]>=n+1){
            nums[i]=n+1;
        }
       } 
       //mark - at the index which number is occure 
       for(int i=0;i<nums.length;i++){
        int element=Math.abs(nums[i]);
        if(element==n+1){
            continue;
        }
        int seat=element-1;
        if(nums[seat]>0){
            nums[seat]=-nums[seat];

        }
       }
       // get answer now 
       for(int i=0;i<nums.length;i++){
        if(nums[i]>0){
            return i+1;
        }
       }
       return n+1;
        //after here i am do itself 
        // int n=nums.length;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]<=0 || nums[i]>n+1){
        //         nums[i]=n+1;
        //     }
        // }
        // for(int i=0;i<nums.length;i++){
        //     int element=Math.abs(nums[i]);
        //     if(element==n+1){
        //         continue;
        //     }
        //     if(nums[element-1]>0){
        //     nums[element-1]=-nums[element-1];
        //     }
        // }
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]>0){
        //         return i+1;
        //     }
        // }
        // return n+1;
    }
}