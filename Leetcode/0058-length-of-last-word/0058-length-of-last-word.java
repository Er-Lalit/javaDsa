class Solution {
    public int lengthOfLastWord(String s) {

    //  List<String> ls=new ArrayList();
    //  int i=0;
    //  int j=0;
    //   while(j<s.length()){
    //       StringBuilder sb=new StringBuilder();
    //         while( j<s.length() && s.charAt(j)!=' '){
    //         sb.append(s.charAt(j));
    //         j++;

    //        }
    //        if(sb.length()>0){
    //       ls.add(String.valueOf(sb));
    //        }
    //        j++;
    //        }
    //        String s1=ls.get(ls.size()-1);
    //        return s1.length();
    // now we see the optimal approach
    int i=s.length()-1;
    while(s.charAt(i)==' '){
        i--;
    }
    int count=0;
        while(i>=0 && s.charAt(i)!=' '){
            i--;
            count++;
        }

return count;
    }
}