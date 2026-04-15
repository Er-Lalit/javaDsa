class Solution {
    static int dp[][][];
    static int Mod= 1000000007;
    public int numOfArrays(int n, int m, int k) {
        dp=new int[n+1][m+1][n+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return recursive(0,0,0,k,n,m);
        
    }
    static int recursive(int len,int max,int cost,int k,int n,int m)
    {
        if(len==n)
        {
            if(k==cost)
            {
                return 1;
            }
            return 0;
        }
        if(dp[len][max][cost]!=-1)
        {
            return dp[len][max][cost];
        }
        int result=0;

        for(int i=1;i<=m;i++)
        {
            if(i>max)
            {
                result=(result+recursive(len+1,i,cost+1,k,n,m))%Mod;

            }
            else
            {
                result=(result+recursive(len+1,max,cost,k,n,m))%Mod;
            }
        }
        return dp[len][max][cost]=result;
    }
}