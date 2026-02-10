class Solution {
    public String freqAlphabets(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;){
            if(i<n-2 && s.charAt(i+2)=='#'){
                String s1=s.substring(i,i+2);
                int value=Integer.parseInt(s1);
                char c=(char)(96+value);
                sb.append(c);
                i=i+3;
                continue;

            }
            char ch=s.charAt(i);

            sb.append((char)(96+(ch-'0')));
            i++;
        }
        return String.valueOf(sb);
        
    }
}