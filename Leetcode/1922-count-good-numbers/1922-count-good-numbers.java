class Solution {
    static long M= 1000000007;
    public int countGoodNumbers(long n) {
        
        long evenPower=findPower(5,(n+1)/2);
        long oddPower=findPower(4,n/2);
        long ans=(evenPower*oddPower)% M;
        return (int) ans;
    }
    static long findPower(long base,long expo){
        if(expo==0){
            return 1;
        }
        long half=findPower(base,expo/2);
        long result=(half*half) %M;
        if(expo%2==1)
        {
            return (base*result)%M;
        }
        return result ;

    }
}