
class Solution {
 public boolean isPalindrom(String s,int i,int j){
        while(i<j){

            if(s.charAt(i)!=s.charAt(j)){
            return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        int maxlength=0;
        int start=0;
        int end=0;
        for (int i = 0; i < length; i++) {
            for(int j=0;j<length;j++){
               if(isPalindrom(s,i,j)==true){
                    if((j-i)+1>maxlength){
                        maxlength=(j-i)+1;
                       start=i;
                       end=j;
                    }

                }
            }

        }
        return s.substring(start,end+1);

    }
}