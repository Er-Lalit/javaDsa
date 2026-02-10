class Solution {
    public String reversePrefix(String word, char ch) {
        int idx=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                idx=i;
                break;
            }
        }
          StringBuilder sb=new StringBuilder();
        
        if(idx<word.length()){
            sb.append(word.substring(0,idx+1));
          
            sb.reverse();

        }
        sb.append(word.substring(idx+1,word.length()));
        return String.valueOf(sb);
        
    }
}