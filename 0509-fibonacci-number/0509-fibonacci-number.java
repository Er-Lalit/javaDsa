class Solution {
    public int fib(int n) {
        int arr[]=new int[n+1];
        return recursive(n,arr);
        
        
    }
    static int recursive(int n,int arr[])
    {
        if(arr[n]!=0)
        {
            return arr[n];
        }
        if(n==1){
            return 1;
        }
        else if(n==0){
            return 0;
        }
       int first= recursive(n-1,arr);
       int second=recursive(n-2,arr);
       int ans=first+second;
       return arr[n]=ans;
    }
}
