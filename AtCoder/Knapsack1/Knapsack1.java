package AtCoder.Knapsack1;
import java.util.*;
public class Knapsack1 {
    static int wait[];
    static int value[];
    static long dp[][];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int w=in.nextInt();
        wait=new int[n];
        value=new int[n];
        dp=new long[n+1][w+1];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++)
        {
            wait[i]=in.nextInt();
            value[i]=in.nextInt();
        }
        System.out.println(solve(0,w));
    }
    static long solve(int idx,int W)
    {
        if(idx==wait.length)
        {
            return 0;
        }
        if(dp[idx][W]!=-1)
        {
            return dp[idx][W];
        }
        long take=Long.MIN_VALUE;
        if(wait[idx]<=W)
        {
            take=value[idx]+solve(idx+1,W-wait[idx]);
        }

        long nTake=solve(idx+1,W);

        return dp[idx][W]=Math.max(take,nTake);
    }
}
