class Solution {
    public boolean checkIfPangram(String sentence) {
  // boolean isPangram=false;
   for(char c='a';c<='z';c++){
    if(!sentence.contains(String.valueOf(c))){
        return false;
    }
   }
   return true;
        
    }
}