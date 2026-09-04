package AtCoder.N_Slimes;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long prefix[];
    static long dp[][];

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int arr[]=new int[n];
        prefix=new long[n+1];
        dp=new long[n][n];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i], -1);
        }
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextInt();
            prefix[i+1]=prefix[i]+arr[i];
        }
        System.out.println(solve(0, n-1));
    
    }
    static long solve(int l,int r)
    {
        if(l==r)
        {
            return 0;
        }
        if(dp[l][r]!=-1)
        {
            return dp[l][r];
        }
        long ans=Long.MAX_VALUE;
        for(int k=l;k<r;k++)
        {
            long left=solve(l,k);
            long right=solve(k+1,r);

            long sum=(prefix[r+1]-prefix[l]);
            long cost=left+right+sum;

            ans=Math.min(ans,cost);


        }
        return dp[l][r]=ans;
    }
    
}
