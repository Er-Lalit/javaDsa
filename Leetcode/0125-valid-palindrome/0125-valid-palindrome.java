class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if((ch>=65 && ch<=90 )|| (ch>=97 && ch<=122) ||(ch>=48 &&ch<=57)){
                sb.append(String.valueOf(ch).toLowerCase());

            }
        }
        s=String.valueOf(sb);
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            else if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
        }
        return true;
    }
}