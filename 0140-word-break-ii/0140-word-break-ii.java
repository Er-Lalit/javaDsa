class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans=new ArrayList<>();
        Stack<String> st=new Stack<>();
       // solve(s, st, ans, wordDict);  
       solve(s,"",ans,0,wordDict);
        return ans;      
        
    }
    // this was nave approach
    // static void solve(String s,Stack<String> st, List<String> ans,List<String> wordDict)
    // {
    //     if(s.isEmpty())
    //     {
    //         StringBuilder sb=new StringBuilder();
    //         for(String s1:st)
    //         {
    //             sb.append(s1+" ");
    //         }
    //         ans.add(sb.toString().trim());

    //     }
    //     for(int i=0;i<s.length();i++)
    //     {
    //         if(!wordDict.contains(s.substring(0,i+1)))
    //         {
    //             continue;
    //         }
    //         if(wordDict.contains(s.substring(0,i+1)))
    //         {
    //             st.push(s.substring(0, i+1));
    //             solve(s.substring(i+1), st, ans, wordDict);
    //             st.pop();
    //         }
    //     }
    // }
// some optimized approach
    static void solve(String s,String currSentence,List<String> ans,int i,List<String> wordDict)
    {
        if(i>=s.length())
        {
            ans.add(currSentence);
            return;
            
        }
        for(int j=i;j<s.length();j++)
        {
            String tempword=s.substring(i,j+1);
            if(wordDict.contains(tempword))
            {
                String tempSentence=currSentence;
                if(!currSentence.isEmpty())
                {
                    currSentence+=" ";
                }
                currSentence+=tempword;
                solve(s,currSentence,ans,j+1,wordDict);
                currSentence=tempSentence;


            }
        }
    }
}