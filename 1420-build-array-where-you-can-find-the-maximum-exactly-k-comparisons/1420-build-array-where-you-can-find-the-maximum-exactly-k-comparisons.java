class Solution {
    static int mod=1000000007;
    static int dp[][][]=new int[51][51][101];
    static int N;
    static int M;
    static int K;
    public int numOfArrays(int n, int m, int k) {
        N=n;
        M=m;
        K=k;
        dp=new int[n+1][k+1][m+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[i].length;j++)
            {
                Arrays.fill(dp[i][j],-1);

            }
            
        }
        return solve(0,0,0);
        
    }
    static int solve(int idx,int sCost,int mSFar)
    {  
        if(idx==N)
        {
            if(sCost==K)
            {
                return 1;
            }
            return 0;
        }
        if(sCost>K)
        {
            return 0;
        }
        if(dp[idx][sCost][mSFar]!=-1)
        {
            return dp[idx][sCost][mSFar];
        }
        int result=0;
        for(int i=1;i<=M;i++)
        {
            if(i>mSFar)
            {
                result=(result+solve(idx+1,sCost+1,i))%mod;
            }
            else
            {
                result=(result+solve(idx+1,sCost,mSFar))%mod;
            }
        }
        return dp[idx][sCost][mSFar]=result%mod;

    }
}