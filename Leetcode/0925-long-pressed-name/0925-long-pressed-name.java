class Solution {
    public boolean isLongPressedName(String name, String typed) {
          int n=name.length();
        int t=typed.length();
        int i=0;
        int j=0;
        while(i<n && j<t){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
                continue;
            }
            if(i>0 && typed.charAt(j)==name.charAt(i-1)){
                j++;
            }else{
                return false;
            }
        } if(i<n){
            return false;
        }
       while(j<t){
            if(typed.charAt(j)!=name.charAt(i-1)){
                return false;
            }
            else{
                j++;
            }
        }
        return true;
    }
}