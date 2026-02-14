class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans=new ArrayList<>();
        Stack<String> st=new Stack<>();
        solve(s, st, ans, wordDict);  
        return ans;      
        
    }
    // this was nave approach
    static void solve(String s,Stack<String> st, List<String> ans,List<String> wordDict)
    {
        if(s.isEmpty())
        {
            StringBuilder sb=new StringBuilder();
            for(String s1:st)
            {
                sb.append(s1+" ");
            }
            ans.add(sb.toString().trim());

        }
        for(int i=0;i<s.length();i++)
        {
            if(!wordDict.contains(s.substring(0,i+1)))
            {
                continue;
            }
            if(wordDict.contains(s.substring(0,i+1)))
            {
                st.push(s.substring(0, i+1));
                solve(s.substring(i+1), st, ans, wordDict);
                st.pop();
            }
        }
    }
// some optimized approach
    //static void sovle(Strin)
}