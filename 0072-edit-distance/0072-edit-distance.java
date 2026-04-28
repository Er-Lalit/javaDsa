class Solution {
    static int dp[][];
    public int minDistance(String word1, String word2) {
        dp=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return solve(word1,word2,word1.length(),word2.length());
        
    }
    static int solve(String s1,String s2,int i,int j)
    {
        if(i==0 || j==0)
        {
            return i+j;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s1.charAt(i-1)==s2.charAt(j-1))
        {
            return solve(s1,s2,i-1,j-1);
        }
      return  dp[i][j]= Math.min(1+solve(s1,s2,i,j-1),Math.min(1+solve(s1,s2,i-1,j),1+solve(s1,s2,i-1,j-1)));
    }
}