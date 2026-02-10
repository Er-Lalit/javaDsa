class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb=new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            int reminder=columnNumber%26;
            sb.append((char)(65+reminder));
            columnNumber=columnNumber/26;
        }
        return String.valueOf(sb.reverse());

    }
}