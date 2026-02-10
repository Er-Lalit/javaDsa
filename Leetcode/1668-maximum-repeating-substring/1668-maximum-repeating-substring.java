class Solution {
    public int maxRepeating(String sequence, String word) {
       int count=0;
       StringBuilder sb=new StringBuilder(word);
       while(Kmp(sequence,String.valueOf(sb))){
        sb.append(word);
        count++;
       }

        return count;
        
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
    static boolean Kmp(String text,String pattern){
        int lps[]=Lps(pattern);
        System.out.println(Arrays.toString(lps));
        int n=text.length();
        int m=pattern.length();
        int i=0;
        int j=0;
        while(i<n){
           
            if( text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }
              if(j==m){
               return true;
            }
            else if(i<n &&  text.charAt(i)!=pattern.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                } else{
                    i++;
                }
            }

        }
        return false;
    }
}