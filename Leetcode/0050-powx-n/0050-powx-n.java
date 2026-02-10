class Solution {
    public double myPow(double x, int n) {
        return recursive(x,(long)n);
        
    }
    static double recursive(double x,long n)
    {
        if(n==0){
            return 1;
        }
        if(n<0)
        {
           return recursive(1/x,-n);
        }
        double half=recursive(x,n/2);
        double result=half*half;
        if(n%2==1)
        {
            result*=x;
        }
        return result;
    }
}