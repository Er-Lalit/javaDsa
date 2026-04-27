class Solution {
    static int dp[][];
    public String shortestCommonSupersequence(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0 ||j==0)
                {
                    dp[i][j]=i+j;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.min(1+dp[i-1][j],1+dp[i][j-1]);
                }
            }
        }
        
        int i=m;
        int j=n;
        StringBuilder sb=new StringBuilder();
        while(i>0 && j>0)
        {
            if(s1.charAt(i-1)!=s2.charAt(j-1))
            {
                if(dp[i-1][j]<dp[i][j-1])
                {
                    sb.insert(0,s1.charAt(i-1));
                    i=i-1;
                }
                else
                {
                    sb.insert(0,s2.charAt(j-1));
                    j=j-1;
                }
            }
            else
            {
                sb.insert(0,s1.charAt(i-1));
                i=i-1;
                j=j-1;
            }
        }
        if(i!=0)
        {
            sb.insert(0,s1.substring(0,i));
        }
        if(j!=0)
        {
            sb.insert(0,s2.substring(0,j));
        }
        return String.valueOf(sb);
        
    }

        
    
    
}