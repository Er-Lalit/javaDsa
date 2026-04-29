class Solution {
    static boolean dp[][];
    static List<List<String>> ans;
    public List<List<String>> partition(String s) {
        dp=new boolean[s.length()][s.length()];
        for(int l=1;l<=s.length();l++)
        {
            for(int i=0;l+i-1<s.length();i++)
            {
                int j=l+i-1;
                if(i==j)
                {
                    dp[i][j]=true;
                }
                else if(s.charAt(i)==s.charAt(j))
                {
                    if(i+1==j)
                    {
                        dp[i][j]=true;
                    }
                    else
                    {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                else
                {
                    dp[i][j]=false;
                }
            }
        }
        ans=new ArrayList<>();
        Stack<String> st=new Stack<>();
        solve(0,s,st);
        return ans;
        
    }
    static void solve(int i,String s,Stack<String> st)
    {
        if(i==s.length())
        {
            ans.add(new ArrayList<>(st));
            return;
        }
        for(int j=i;j<s.length();j++)
        {
            if(dp[i][j])
            {
                st.push(s.substring(i,j+1));
                solve(j+1,s,st);
                st.pop();
            }
        }
                
    }
    
}