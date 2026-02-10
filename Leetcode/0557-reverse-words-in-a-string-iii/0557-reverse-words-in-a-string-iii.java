class Solution {
    public String reverseWords(String s) {
        String arr[]=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            String s1=arr[i];
            StringBuilder sb1=new StringBuilder(s1);
            sb.append(sb1.reverse());
            if(i<arr.length-1){
            sb.append(" ");
            }


        }
        return String.valueOf(sb);
        
    }
}