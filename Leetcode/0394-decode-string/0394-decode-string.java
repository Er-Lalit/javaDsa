class Solution {
    public String decodeString(String s) {
        Stack<String> stringS=new Stack<>();
        Stack<Integer> integerS=new Stack<>();
        int k=0;
        for(char c:s.toCharArray())
        {
            if(Character.isDigit(c))
            {
                k=(k*10)+(c-'0');
                continue;
            }
            if(c=='[')
            {
                integerS.push(k);
                k=0;
                stringS.push(String.valueOf(c));
                continue;
            }
            if(c!=']')
            {
                stringS.push(String.valueOf(c));
                continue;
            }
            StringBuilder temp=new StringBuilder();
            while(!stringS.peek().equals("["))
            {
                temp.insert(0,stringS.pop());
               


            }
            stringS.pop();
            StringBuilder rep=new StringBuilder();
            int count=integerS.pop();
            for(int i=0;i<count;i++)
            {
                rep.append(temp);
            }
            stringS.push(rep.toString());

        }
        StringBuilder ans=new StringBuilder();
        while(!stringS.isEmpty())
        {
            ans.insert(0,stringS.pop());
        }
        return ans.toString();
           
    }
}