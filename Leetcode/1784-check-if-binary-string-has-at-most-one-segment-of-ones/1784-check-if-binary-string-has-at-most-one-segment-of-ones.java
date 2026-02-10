class Solution {
    public boolean checkOnesSegment(String s) {
      if(s.length()==1){
        return true;
      }
      int change=0;
      for(int i=1;i<s.length();i++){
        if(s.charAt(i)!=s.charAt(i-1)){
            change++;
        }
      }
      if(change>=2){
        return false;
      }
      else{
        return true;
      }
    }
}