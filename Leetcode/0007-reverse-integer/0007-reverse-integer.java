import java.util.*;
class Solution {
    public int reverse(int x) {
          String s=String.valueOf(x);
       String s1="";
        ArrayDeque<String> ad=new ArrayDeque<>();
        if(x>=0){
        for(int i=0;i<=s.length()-1;i++){
            if(i==s.length()-1){
                if((int)s.charAt(i)==0){
                    continue;
                }
            }
            ad.addFirst(String.valueOf(s.charAt(i)));
        }
    }
    else{
        s1=String.valueOf(s.charAt(0));
        for(int i=1;i<=s.length()-1;i++){
            if(i==s.length()-1){
                if((int)s.charAt(i)==0){
                    continue;
                }
            }
            ad.addFirst(String.valueOf(s.charAt(i)));
        }

        }
    ad.addFirst(s1);
    
    
        String a="";
        for(String b:ad){
            a+=b;


        }
        long f=Long.parseLong(a);
        long min=(long)-Math.pow(2,31);
        long max=(long)Math.pow(2,31)-1;
        if(f<min || f>max){
            return 0;
            
        }
        int j=Integer.parseInt(a);
        return j;
        
        
    }
}