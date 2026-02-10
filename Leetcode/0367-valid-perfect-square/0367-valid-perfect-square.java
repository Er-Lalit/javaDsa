class Solution {
    public boolean isPerfectSquare(int num) {
        long low=1;
        long high=num;
        while(low<=high){
            long mid=(low+high)/2;
            long mul=mid*mid;
            if(mul==num){
                return true;
            }
            else if(mul<num){
                low=mid+1;
            }
            else if(mul>num){
                high=mid-1;
            }
        }
        return false;
    }
}