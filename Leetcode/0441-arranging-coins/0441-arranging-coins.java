class Solution {
    public int arrangeCoins(int n) {
    long lb=1; 
    long ub=n;
    while(lb<=ub){
        long mid=(lb+ub)/2;
        long element=(mid*(mid+1))/2;
        if(element==n){
            return (int)mid;
        }
        else if(element>n){
            ub=mid-1;
        }
        else{
            lb=mid+1;
        }
    }
    return (int)ub;
    }
}