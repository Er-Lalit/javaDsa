class Solution {
    public String longestCommonPrefix(String[] strs) {
       Arrays.sort(strs);
       String first=strs[0];
       String last=strs[strs.length-1];
       StringBuilder sb=new StringBuilder();
       int length=Math.min(first.length(),last.length());
       int i=0;
       while(i<length){
        if(first.charAt(i)!=last.charAt(i)){
            return String.valueOf(sb);
        }
        else{
           
            sb.append(first.charAt(i));
             i++;
        }
       }
       return String.valueOf(sb);
    }
}