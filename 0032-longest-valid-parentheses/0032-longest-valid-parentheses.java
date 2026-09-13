class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        int i=0;
        while(i<s.length())
        {
            if(s.charAt(i)=='(')
            {
                st.push(i);
            }
            else
            {
                if(!st.isEmpty() && s.charAt(st.peek())=='(')
                {
                    st.pop();
                }
                else
                {
                    st.push(i);
                }
            }
            i++;
        }
        List<Integer> index=new ArrayList<>();
        while(!st.isEmpty())
        {
            index.add(0,st.pop());
        }
        int ans=0;
        if(!index.isEmpty())
        {
            ans=index.get(0);
        }
        for(int j=1;j<index.size();j++)
        {
            int diff=index.get(j)-index.get(j-1)-1;
            ans=Math.max(diff,ans);

        }

        if (!index.isEmpty()) {
            ans = Math.max(
                ans,
                s.length() - index.get(index.size() - 1) - 1
            );
        } 
        else {
            // Entire string is valid
            ans = s.length();
        }

        return ans;
        
        
    }
}