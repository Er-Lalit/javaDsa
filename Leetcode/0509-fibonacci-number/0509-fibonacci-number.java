class Solution {
    public int fib(int n) {
        if(n==1){
            return 1;
        }
        else if(n==0){
            return 0;
        }
       int first= fib(n-1);
       int second=fib(n-2);
       int ans=first+second;
       return ans;
        
    }
}