class Solution {
    public int calculate(String s) {
        int number=0;
        int sing=1;
        int result=0;
        Stack<Integer> st=new Stack();
        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                number=(number*10)+(s.charAt(i)-'0');
            }
            else if(s.charAt(i)=='+')
            {
                result+=number*sing;
                number=0;
                sing=1;

            }
            else if(s.charAt(i)=='-')
            {
                result+=number*sing;
                number=0;
                sing=-1;

            }
            else if(s.charAt(i)=='(')
            {
                st.push(result);
                st.push(sing);
                result=0;
                sing=1;
                number=0;


            }
            else if(s.charAt(i)==')')
            {
                result+=number*sing;
                number=0;

                int pSing=st.pop();
                int pAns=st.pop();
                result*=pSing;
                result+=pAns;

            }
            
        }
        result+=number*sing;
        return result;
    }
}