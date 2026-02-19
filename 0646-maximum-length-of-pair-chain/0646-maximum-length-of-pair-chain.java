class Solution {
    static int dp[][];
    public int findLongestChain(int[][] pairs) {
        dp=new int[pairs.length+1][pairs.length+2];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        return solve(0,pairs,-1);
        
    }
    int solve(int i,int pairs[][],int p)
    {
        if(dp[i][p+1]!=-1)
        {
            return dp[i][p+1];
        }
        if(i==pairs.length)
        {
            return 0;
        }
        
        int take=0;
        int skip=0;
        if(p==-1|| pairs[i][0]>pairs[p][1])
        {
            take=1+solve(i+1,pairs,i);
        }
        skip=solve(i+1,pairs,p);
        return dp[i][p+1]=Math.max(take,skip);
    }
}