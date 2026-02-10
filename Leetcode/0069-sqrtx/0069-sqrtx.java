class Solution {
    public int mySqrt(int x) {
        long low=1;
        long high=x;
        int ans=1;
        while(low<=high){
            long mid=(low+high)/2; 
            long val=mid*mid; 
            if(val==x){
                return (int)mid;
            } 
          else  if(val<x){
                //ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;

            }
        }
        return (int)high;
    }
}