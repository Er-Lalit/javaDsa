package Codeforces.HardProblem706C;

import java.util.*;
public class Main{
    static long INF=Long.MAX_VALUE /2;
    static int n;
    static Long cost[];
    static String s[];
    static String reverse[];
    static long dp[][];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        cost=new Long[n];
        dp=new long[n][2];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++)
        {
            cost[i]=in.nextLong();
        }
        s=new String[n];
        reverse=new String[n];

        for(int i=0;i<n;i++)
        {
            s[i]=in.next();
            reverse[i]=new StringBuilder(s[i]).reverse().toString();
        }

        long ans1=solve(1,0);
        long ans2=cost[0]+solve(1,1);

        long fAns=Math.min(ans1,ans2);
        if(fAns==INF)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(fAns);
        }

    }
    static long solve(int i,int prevState)
    {
        if(i==n)
        {
            return 0;
        }
        if(dp[i][prevState]!=-1)
        {
            return dp[i][prevState];
        }

        long ans=INF;
        String prev;
        if(prevState==0)
        {
            prev=s[i-1];
        }
        else
        {
            prev=reverse[i-1];
        }

        if(s[i].compareTo(prev)>=0)
        {
            ans=Math.min(ans,solve(i+1,0));
        }
        if(prev.compareTo(reverse[i])<=0)
        {
            ans=Math.min(ans,cost[i]+solve(i+1,1));
        }

        return dp[i][prevState]= ans;

    }

}