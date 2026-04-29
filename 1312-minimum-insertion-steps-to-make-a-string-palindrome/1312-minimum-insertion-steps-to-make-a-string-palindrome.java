class Solution {
    static int dp[][];
    public int minInsertions(String s) {
        dp=new int[s.length()+1][s.length()+1];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return solve(s,0,s.length()-1);
        
    }
    static int solve(String s,int i ,int j)
    {
        if(i>=j)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j))
        {
            return solve(s,i+1,j-1);
        }
        else
        {
            return dp[i][j]= Math.min(1+solve(s,i+1,j),1+solve(s,i,j-1));
        }
    }
}