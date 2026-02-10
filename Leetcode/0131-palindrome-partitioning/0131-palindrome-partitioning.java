class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        Stack<String> current=new Stack<>();
        backtrack(s,0,current,result);
        return result;
        
    }
    public static void backtrack(String s,int idx,Stack<String> current,List<List<String>> result){
        if(idx==s.length())
        {
            result.add(new ArrayList<>(current));
            return;
        }
        

        
        for(int i=idx;i<s.length();i++)
        {
            if(isPalindrome(s.substring(idx,i+1))){
                current.push(s.substring(idx,i+1));
                backtrack(s,i+1,current,result);
                current.pop();
            }
        }

    }
    public static boolean isPalindrome(String s)
    {
        int start=0;
        int end=s.length()-1;
        while(start<end)
        {
            if(s.charAt(start)!=(s.charAt(end)))
            {
                return false;
            }
            start++;
            end--;
           
        }
     return true;

    }
}