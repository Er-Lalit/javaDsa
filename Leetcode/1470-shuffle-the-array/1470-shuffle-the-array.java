class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] elements=new int[nums.length];
        int length=0;
        int i=0;
        int j=n;
        while(length<nums.length){
            elements[length]=nums[i];
            length++;
            elements[length]=nums[j];
            length++;
            i++;
            j++;
        }
        return elements;
    }
}