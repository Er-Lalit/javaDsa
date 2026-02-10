class Solution {
    public boolean judgeCircle(String moves) {
        // int lr=0;
        // int ud=0;
        // for(int i=0;i<moves.length();i++){
        //     char ch=moves.charAt(i);
            
        //     if(ch=='L'){
        //         lr++;

        //     }
        //     else if(ch=='R'){
        //         lr--;
        //     }
        //     else if(ch=='U'){
        //         ud++;
        //     }
        //     else if(ch=='D'){
        //         ud--;
        //     }
        // }
         int lr = 0, ud = 0;
    for (char ch : moves.toCharArray()) {
        switch (ch) {
            case 'L': lr--; break;
            case 'R': lr++; break;
            case 'U': ud++; break;
            case 'D': ud--; break;
        }
    }
        return (lr==0 && ud==0);
    }
}