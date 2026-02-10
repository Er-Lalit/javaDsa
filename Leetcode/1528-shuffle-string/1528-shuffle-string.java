class Solution {
    public String restoreString(String s, int[] indices) {
        char ch[]=new char[s.length()];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int idx=indices[i];
            ch[idx]=c;

        }
        return new String(ch);
        
        // StringBuilder sb=new StringBuilder();
        // for(int i=0;i<s.length();i++){
        //     sb.append(ch[i]);
        // }
        // return String.valueOf(sb);
        
    }
}