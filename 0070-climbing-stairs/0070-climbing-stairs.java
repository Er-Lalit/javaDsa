class Solution {
    public int climbStairs(int n) {
        int arr[]=new int[n+1];
       return  solve(n,arr);
        
    }
    static int solve(int n,int arr[])
    {
        int count=0;
        
        if(n==0)
        {
            return 1;
        }
        else if(n<0)
        {
            return 0;
        }
        if(arr[n]!=0)
        {
            return arr[n];
        }
       count+= solve(n-1,arr);
       count+= solve(n-2,arr);
       return arr[n]=count;
    }
    
    
}