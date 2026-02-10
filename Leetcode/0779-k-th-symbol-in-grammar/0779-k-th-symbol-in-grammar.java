class Solution {
    public int kthGrammar(int n, int k) {
        int len=(int)Math.pow(2,n-1);
        if(n==1)
        {
            return 0;
        }
        if(k<=len/2)
        {
         return   kthGrammar(n-1,k);
        }
        else
        {
            int ans=kthGrammar(n-1,k-len/2);
            return(ans==0)?1:0;
        }
        
    }
}