class Solution {
    static int M=1000000007;
    public int minNonZeroProduct(int p) {
        long twoP=recursive(2,p);
        long exponential=power(2,p-1)-1;
        long secondSide=recursive(twoP-2,exponential);
    
         long ans = ((twoP - 1) * secondSide) % M;

        return(int) ans;
        
    }
    static long recursive(long a,long b){
        if(b==0){
            return 1;
        }
        long half=recursive(a,b/2);
        long result=(half*half)%M;
        if(b%2==1)
        {
            result=(a*result)%M;

        }
        return result;
    }
    static long power(long a,long b)
    {
        if(b==0)
        {
            return 1;
        }
        long half=power(a,b/2);
        long result=(half*half);
        if(b%2==1)
        {
            result=a*result;
        }
        return result;
    }
}