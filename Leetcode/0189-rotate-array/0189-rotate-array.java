class Solution {
    static void reverse(int [] nums,int start,int end){
        while(start<end){
          int  temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

     public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
       
    //     k=k%nums.length;
    //     int[] arr=new int[nums.length];
    //     int idx=0;
    //    for(int i=nums.length-k;i<=nums.length-1;i++){
    //     arr[idx]=nums[i];
    //     idx++;

    //    }
    //   int var=k;
    //   for(int i=0;i<nums.length-k;i++){
    //     arr[var]=nums[i];
    //     var++;
    //   }
    //     for(int i=0;i<arr.length;i++){
    //     nums[i]=arr[i];

    //     }
   }
       
 }
        
