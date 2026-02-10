class Solution {
    public int findNumbers(int[] nums) {
        int evenDigits=0;
        for(int i=0;i<nums.length;i++){
            int number=nums[i];
            int length=(int)Math.log10(number)+1;
            if(length%2==0){
                evenDigits++;
            }
        }
        return evenDigits;
        
    }
}