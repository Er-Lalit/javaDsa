class Solution {
    public boolean parseBoolExpr(String expression) {
        return solve(expression);

        
    }
   static boolean solve(String s)
    {
        Stack<Character> op=new Stack<>();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='!' || ch=='&' || ch=='|')
            {
                op.push(ch);
               
                continue; 
            }
            else if(ch=='t' ||ch=='f' || ch=='(')
            {
                st.push(ch);
              
                continue;
            }
            else if(ch==',')
            {
                
                ;
                continue;
               
            }
            List<Character> temp=new ArrayList();
            while(st.peek() != '(')
            {
                temp.add(st.pop());
            }
            st.pop();
            char sym=op.pop();
            char result=solvExp(temp,sym);
            st.push(result);


        }
        return st.pop()=='t'?true:false;

       
    }
    static char solvExp(List<Character> temp,char sym)
    {
        if(sym=='!')
        {
            return temp.get(0)=='t'?'f':'t';
        }
        else if(sym=='&')
        {
            for(char c:temp)
            {
                if(c=='f')
                {
                    return 'f';
                }
                
            }
            return 't';
        }
        else if(sym=='|')
        {
            for(char c:temp)
            {
                if(c=='t')
                {
                    return 't';
                }
                
            }
            return 'f';
        }
        return 'f';
        
    }  
}