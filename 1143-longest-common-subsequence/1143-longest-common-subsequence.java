class Solution {
    static int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        
        dp=new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return solve(text1,text2,0,0);
    }
    static int solve(String s1,String s2,int i,int j)
    {
        if(i>=s1.length() || j>=s2.length())
        {
            return 0;
        }
        if(s1.charAt(i)==s2.charAt(j))
        {
            return 1+solve(s1,s2,i+1,j+1);
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        else
        {
            return dp[i][j]=Math.max(solve(s1,s2,i,j+1),solve(s1,s2,i+1,j));
        }
    }

}