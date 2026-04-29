class Solution {
    public String longestPalindrome(String s) {
        boolean dp[][]=new boolean[s.length()][s.length()];
        for(int l=1;l<=s.length();l++)
        {
            for(int i=0;l+i-1<s.length();i++)
            {
                int j=l+i-1;
                if(i==j)
                {
                    dp[i][j]=true;
                }
                else if(i+1==j)
                {
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                }
                else
                {
                    dp[i][j]=(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]);
                }

            }
        }
        int fIdx=0;
        int lIdx=0;
        for(int l=2;l<=s.length();l++)
        {
            for(int i=0;l+i-1<s.length();i++)
            {
                int j=l+i-1;
                if(dp[i][j]==true)
                {
                    fIdx=i;
                    lIdx=j;
                    break;
                }
            }
        }
        return s.substring(fIdx,lIdx+1);
        
    }
}