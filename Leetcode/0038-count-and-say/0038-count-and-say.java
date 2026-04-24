class Solution {
    public String countAndSay(int n) {
        return recursive(n);
        
    }
    static String recursive(int n)
    {
        if(n==1)
        {
            return "1";
        }
        String s=recursive(n-1);

        StringBuilder sb=new StringBuilder();

        char st;
        int count=0;

        for(int i=0;i<s.length()-1;i++)
        {
            st=s.charAt(i);
            count+=1;
            if(s.charAt(i)!=s.charAt(i+1))
            {
                sb.append(""+count);
                sb.append(""+st);
                count=0;
            }

        }
        count+=1;
        sb.append(""+count);
        sb.append(""+s.charAt(s.length()-1));

        return String.valueOf(sb);
    }
}