class Solution {
    static int[] arr=new int[10001];
    public int numSquares(int n) {
        return helper(n);

        
    }
    static int helper(int n)
    {
        if(arr[n]!=0)
        {
            return arr[n];
        }
        if(n==0)
        {
            return 0;
        }
        int minCount=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++)
        {
            int result=1+helper(n-i*i);
            minCount=Math.min(minCount,result);
        }
        return arr[n]=minCount;
    }
}