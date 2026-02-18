class Solution {
    public int climbStairs(int n) {
        if(n<=2)
        {
            return n;
        }
        int arr[]=new int[n+1];
        arr[1]=1;
        arr[2]=2;
       return  solve(n,arr);
        
    }
    // with dp memoization
    // static int solve(int n,int arr[])
    // {
    //     int count=0;
        
    //     if(n==0)
    //     {
    //         return 1;
    //     }
    //     else if(n<0)
    //     {
    //         return 0;
    //     }
    //     if(arr[n]!=0)
    //     {
    //         return arr[n];
    //     }
    //    count+= solve(n-1,arr);
    //    count+= solve(n-2,arr);
    //    return arr[n]=count;
    // }
    //bottom up approach
    static int solve(int n,int arr[])
    {
        for(int i=3;i<arr.length;i++)
        {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    
    
}