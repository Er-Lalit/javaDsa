class Solution {
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);
        // int n=haystack.length();
        // int m=needle.length();
        // for(int i=0;i<=n-m;i++){
        //     for(int j=0;j<m;j++){
        //         if(haystack.charAt(i+j)!=needle.charAt(j)){
        //             break;
        //         }
        //         if(j==needle.length()-1){
        //             return i;
        //         }
        //     }
        // }
        // return -1;
        int result=Kmp(haystack,needle);
        return result;
    }
     static int[] Lps(String pattern){
        int lps[]=new int[pattern.length()];
        lps[0]=0;
        int i=1;
        int length=0;
        while(i<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(length)){
                lps[i]=length+1;
                length=length+1;
                i++;
            }
            else{
                if(length!=0){
                    length=lps[length-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }

        }

        return lps;
    }
    static int Kmp(String text,String pattern){
        int lps[]=Lps(pattern);
        int n=text.length();
        int m=pattern.length();
        int i=0;
        int j=0;
        while(i<n){
            
            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }
             if(j==m){
                return i-j;
            }
            else if(i<n && text.charAt(i)!=pattern.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                } else{
                    i++;
                }
            }

        }
        return -1;
    }
}