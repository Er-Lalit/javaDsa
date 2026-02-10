class Solution {
    public String convert(String s, int numRows) {
         if(numRows==1){
            return s;
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<numRows;i++){
             int idx=i;
             int below=2*(numRows-1-i);
             int above=2*(i);
             boolean belowgo=true;
        
        while(idx<s.length()){
            sb.append(s.charAt(idx));


            if(i==0){
                idx+=below;

            }
            else if(i==(numRows-1)){
                idx+=above;
            }
            else{
                if(belowgo){
                    idx+=below;
                }
                else{
                    idx+=above;
                }
                belowgo=!belowgo;
            }

        }
        }
        return sb.toString();
        
    }
}