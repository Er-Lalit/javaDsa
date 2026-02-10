class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        list.addAll(List.of("","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"));
        return recursive("",digits,list);

    }


    static List<String> recursive(String p,String up,List<String> s)
    {
        if(up.isEmpty())
        {
            List<String> ret=new ArrayList();
            ret.add(p);
            return ret;
        }
       int digit=up.charAt(0)-'0';
       String s1=s.get(digit);
       List<String> ans=new ArrayList<>();
       for(int i=0;i<s1.length();i++)
       {
         char ch=s1.charAt(i);
         ans.addAll(recursive(p+ch, up.substring(1), s));
       }
       return ans;
        

    }


}