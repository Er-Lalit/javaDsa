class Solution {
    public boolean halvesAreAlike(String s) {
        // int half=s.length()/2;
        // String s1=s.substring(0,half);
        // String s2=s.substring(half,s.length());
        // int count1=0;
        // int count2=0;
        // for(int i=0;i<s1.length();i++){
        //     char ch=s1.charAt(i);
        //     if(ch=='a'|| ch== 'e'|| ch== 'i'|| ch== 'o'||ch== 'u' ||ch=='A'|| ch== 'E' || ch=='I'||ch== 'O'||ch== 'U'){
        //         count1++;

        //     }
        // }
        // for(int i=0;i<s2.length();i++){
        //     char ch=s2.charAt(i);
        //     if(ch=='a'|| ch== 'e'|| ch== 'i'|| ch== 'o'||ch== 'u' ||ch=='A'|| ch== 'E' || ch=='I'||ch== 'O'||ch== 'U'){
        //         count2++;

        //     }
        // }
        // return count1==count2;
        String vowels="aeiouAEIOU";
        int n=s.length();
        int count=0;
        for(int i=0;i<n/2;i++){
            if(vowels.indexOf(s.charAt(i))!=-1){
                count++;
            }
            if(vowels.indexOf(s.charAt(n-i-1))!=-1){
                count--;
            }

        }
        return count==0;
    }
}