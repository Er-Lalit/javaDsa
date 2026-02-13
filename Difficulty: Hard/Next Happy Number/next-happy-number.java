// User function Template for Java

class Solution {

    static int nextHappy(int N) {
        // code here
        N++;
        while(true)
        {
            if(solve(N))
            {
                return N;
            }
            else
            {
                N++;
            }
        }
    }
    static boolean solve(int N)
    {
        if(N==1 || N==7)
        {
            return true;
        }
        if(N<=9)
        {
            return false;
        }
        int sum=0;
        while(N>0)
        {
            int d=N%10;
            sum+=d*d;
            N=N/10;
            
        }
        return solve(sum);
    }
}    