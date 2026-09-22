class Solution {
    public String convert(String s, int numsRows) {

        if(numsRows==1 || numsRows>=s.length())
        {
            return s;
        }

        StringBuilder sb[]=new StringBuilder[numsRows];
        for(int i=0;i<numsRows;i++)
        {
            sb[i]=new StringBuilder();
        }

        int row=0;
        int direction=1;
        for(int i=0;i<s.length();i++)
        {
            sb[row].append(s.charAt(i));

            if(numsRows-1==row)
            {
                direction=-1;
            }
            else if(row==0)
            {
                direction=1;
            }

            row+=direction;

        }

        StringBuilder ans=new StringBuilder();
        for(int i=0;i<sb.length;i++)
        {
            ans.append(sb[i]);
        }
        return ans.toString();

        
    }
}