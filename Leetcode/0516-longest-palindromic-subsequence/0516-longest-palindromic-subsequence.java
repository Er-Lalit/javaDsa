class Solution {
    // static int dp[][];
    // public int longestPalindromeSubseq(String s) {
    //     dp=new int[s.length()+1][s.length()+1];
    //     for(int i=0;i<dp.length;i++)
    //     {
    //         Arrays.fill(dp[i],-1);

    //     }
    //     return solve(s,0,s.length()-1);
    // }
    // static int solve(String s,int i,int j)
    // {
    //     if(i>j)
    //     {
    //         return 0;
    //     }
    //     if(i==j)
    //     {
    //         return 1;
    //     }
    //     if(dp[i][j]!=-1)
    //     {
    //         return dp[i][j];
    //     }
    //     if(s.charAt(i)==s.charAt(j))
    //     {
    //         return  2+solve(s,i+1,j-1);
    //     }

    //     return dp[i][j]=Math.max(solve(s,i+1,j),solve(s,i,j-1));
        
    // }
    public int longestPalindromeSubseq(String s) {
        int dp[][]=new int[s.length()][s.length()];
        for(int l=1;l<=s.length();l++)
        {
            for(int i=0;l+i-1<s.length();i++)
            {
                int j=l+i-1;
               if(i==j)
               {
                dp[i][j]=1;
               }
               else
               {
                if(s.charAt(i)==s.charAt(j))
                {
                    dp[i][j]=2+dp[i+1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                }
               }
            }
            
        }
        return dp[0][s.length()-1];
    }
}