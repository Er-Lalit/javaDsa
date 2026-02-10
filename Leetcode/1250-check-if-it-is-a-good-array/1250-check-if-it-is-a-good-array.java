class Solution {
    public boolean isGoodArray(int[] nums) {
          int g=nums[0];
       for(int i=1;i<nums.length;i++){
        g=gcd(g,nums[i]);
        if(g==1){
            return true;
        }
       }
       return g==1;
    }
    static int gcd(int a,int b){
        while(a>0 && b>0){
            if(a>b){
                a=a%b;
            }
            else{
                b=b%a;
            }
        }
        return Math.max(a,b);
    }
}