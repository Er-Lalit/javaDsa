package Codeforces.HardProblem706C;
// this was the simple recursion and memo
import java.util.*;
// public class Main{
//     static long INF=Long.MAX_VALUE /2;
//     static int n;
//     static Long cost[];
//     static String s[];
//     static String reverse[];
//     static long dp[][];
//     public static void main(String[] args) {
//         Scanner in=new Scanner(System.in);
//         n=in.nextInt();
//         cost=new Long[n];
//         dp=new long[n][2];
//         for(int i=0;i<dp.length;i++)
//         {
//             Arrays.fill(dp[i],-1);
//         }
//         for(int i=0;i<n;i++)
//         {
//             cost[i]=in.nextLong();
//         }
//         s=new String[n];
//         reverse=new String[n];

//         for(int i=0;i<n;i++)
//         {
//             s[i]=in.next();
//             reverse[i]=new StringBuilder(s[i]).reverse().toString();
//         }

//         long ans1=solve(1,0);
//         long ans2=cost[0]+solve(1,1);

//         long fAns=Math.min(ans1,ans2);
//         if(fAns==INF)
//         {
//             System.out.println(-1);
//         }
//         else
//         {
//             System.out.println(fAns);
//         }

//     }
//     static long solve(int i,int prevState)
//     {
//         if(i==n)
//         {
//             return 0;
//         }
//         if(dp[i][prevState]!=-1)
//         {
//             return dp[i][prevState];
//         }

//         long ans=INF;
//         String prev;
//         if(prevState==0)
//         {
//             prev=s[i-1];
//         }
//         else
//         {
//             prev=reverse[i-1];
//         }

//         if(s[i].compareTo(prev)>=0)
//         {
//             ans=Math.min(ans,solve(i+1,0));
//         }
//         if(prev.compareTo(reverse[i])<=0)
//         {
//             ans=Math.min(ans,cost[i]+solve(i+1,1));
//         }

//         return dp[i][prevState]= ans;

//     }

// }

// this is the dp code 
public class Main
{
 public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
       int n=in.nextInt();
       long[] cost=new long[n];
       long[][] dp=new long[n][2];
       long INF=Long.MAX_VALUE /2;
       
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],INF);
        }
        for(int i=0;i<n;i++)
        {
            cost[i]=in.nextLong();
        }
        String[] s=new String[n];
        String[] reverse=new String[n];

        for(int i=0;i<n;i++)
        {
            s[i]=in.next();
            reverse[i]=new StringBuilder(s[i]).reverse().toString();
        }
        dp[0][0]=0;
        dp[0][1]=cost[0];

        for(int i=1;i<n;i++)
        {
            String previousNormal=s[i-1];
            String previousReverse=reverse[i-1];

            if(previousNormal.compareTo(s[i])<=0)
            {
                dp[i][0]=Math.min(dp[i][0],dp[i-1][0]);
            }
            if(previousReverse.compareTo(s[i])<=0)
            {
                dp[i][0]=Math.min(dp[i][0],dp[i-1][1]);
            }

            if(previousNormal.compareTo(reverse[i])<=0)
            {
                dp[i][1]=Math.min(dp[i][1],cost[i]+dp[i-1][0]);
            }
            if(previousReverse.compareTo(reverse[i])<=0)
            {
                dp[i][1]=Math.min(dp[i][1],cost[i]+dp[i-1][1]);
            }

        }
        long ans=Math.min(dp[n-1][0],dp[n-1][1]);
        System.out.println(ans>=INF?-1:ans);

    }
}    