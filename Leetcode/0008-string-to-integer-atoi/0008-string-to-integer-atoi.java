class Solution {
   int myAtoi(String s) {
        if(s.isEmpty()){
            return 0;
        }
        s=s.trim();
        boolean sing=true;
        long digit=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(i==0){
                if(c=='-'){
                    sing=false;
                    continue;
                }
                else if(c=='+'){
                    sing=true;
                    continue;
                    
                }
            }
            if(c>='0' && c<='9'){
                int num=c-'0';
                digit=digit*10+num;
                if(sing){
                    long check=digit;
                    if(check>Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                }
                else if(!sing){
                    long check=-digit;
                    if(check<Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;

                    }
                }



            }
            else{
                break;
            }
        }
        if(sing){
            return (int)digit;
        }
        else{
            return (int)-digit;
        }
        
    }
}