class Solution {
    public String makeLargestSpecial(String s) {
        int count=0;
        int start=0;
        List<String> temp=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                count++;
            }
            else if(s.charAt(i)=='0')
            {
                count--;
            }
            if(count==0)
            {
                String inside=makeLargestSpecial(s.substring(start+1,i));
                temp.add("1"+inside+"0");
                start=i+1;
            }


        }
        Collections.sort(temp,Collections.reverseOrder());
        StringBuilder sb=new StringBuilder();
        for(String l1:temp)
        {
            sb.append(l1);
        }
        return sb.toString();
        
    }
}