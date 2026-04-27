package ShortestCommanSupersequence;

class Solution {
    // static int dp[][];
    // public static int minSuperSeq(String s1, String s2) {
    //     dp=new int[s1.length()+1][s2.length()+1];
    //     for(int i=0;i<dp.length;i++)
    //     {
    //         Arrays.fill(dp[i],-1);
    //     }
    //     return solve(s1,s2,0,0);
        
    // }
    // static int solve(String s1,String s2,int i, int j)
    // {
    //     if(i==s1.length())
    //     {
    //         return s2.length()-j;
    //     }
    //     if(j==s2.length())
    //     {
    //         return s1.length()-i;
    //     }
    //     if(dp[i][j]!=-1)
    //     {
    //         return dp[i][j];
    //     }
    //     if(s1.charAt(i)==s2.charAt(j))
    //     {
    //         return 1+solve(s1,s2,i+1,j+1);
    //     }
    //     else
    //     {
    //         return dp[i][j]=Math.min(1+solve(s1,s2,i+1,j),1+solve(s1,s2,i,j+1));
    //     }
    // }
    public static int minSuperSeq(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<m+1;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=i+j;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.min(1+dp[i][j-1],1+dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}