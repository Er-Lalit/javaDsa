class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans=new ArrayList<>();
        Stack<String> st=new Stack<>();
         solve(s, st, ans, wordDict,0);  
        return ans;      
        
    }
   static void solve(String s,Stack<String> st, List<String> ans,List<String> wordDict,int i)
    {
        if(i>=s.length())
        {    
            StringBuilder sb=new StringBuilder();
            for(String s1:st)
            {
                sb.append(s1+" ");
            }
            ans.add(sb.toString().trim());
            

        }
        for(int j=i;j<s.length();j++)
        {
            if(!wordDict.contains(s.substring(i,j+1)))
            {
                continue;
            }
            if(wordDict.contains(s.substring(i,j+1)))
            {
                st.push(s.substring(i,j+1));
                solve(s, st, ans, wordDict,j+1);
                st.pop();
            }
        }
    }
}