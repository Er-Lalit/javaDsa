class Solution {
    public char findKthBit(int n, int k) {
        int len=(int)Math.pow(2,n)-1;
        return recursive(n,k,len);
    }    
    //this is the brutforce approach to do this question 
    //     String s="0";
    //     String ans=backtrack(s,1,n);
    //     return ans.charAt(k-1);
        
    // }
    // static String backtrack(String s,int idx, int n)
    // {
    //     if(idx==n)
    //     {
    //         return s;
    //     }
    //     s=s+"1";
    //     for(int i=s.length()-2;i>=0;i--)
    //     {
    //         if(s.charAt(i)=='0')
    //         {
    //             s=s+"1";
    //         }
    //         else{
    //             s=s+"0";
    //         }
    //     }
    //     return backtrack(s,idx+1,n);
    // this is the optimal approach to do this question 
    static char recursive(int n,int k,int len)
    {
        if(n==1)
        {
            return '0';
        }
        int half=len/2;
        int middle=half+1;
        if(k==middle)
        {
            return '1';
        }
        else if(k<middle)
        {
           return recursive(n-1,k,len/2);
        }
        else
        {
            char ans=recursive(n-1,1+len-k,len/2);
            return(ans=='0')?'1':'0';

        }
    }
}