
 class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] arr=new int[2*nums.length];
           //int[] arr=new int[2*nums.length];
        int j=0;
        int length=nums.length-1;
       
       for(int i=0;i<arr.length;i++){
       
        arr[i]=nums[j];
        j++;
        if(j>length){
            
            j=0;
           
        }
       
       }
       return arr;
    }
   
}