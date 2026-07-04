package AtCoder.Knapsack1;
import java.util.*;
public class Knapsack1 {
    static int wait[];
    static int value[];
    static int dp[][];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int w=in.nextInt();
        wait=new int[n];
        value=new int[n];
        dp=new int[n+1][n+1];
        for(int i=0;i<n;i++)
        {
            wait[i]=in.nextInt();
            value[i]=in.nextInt();
        }
    }
    static long solve(int idx,int W)
    {
        if(idx==wait.length)
        {
            return 0;
        }
        long take=Long.MIN_VALUE;
        if(wait[idx]<=W)
        {
            take=value[idx]+solve(idx+1,W-wait[idx]);
        }

        long nTake=solve(idx+1,W);

        return Math.max(take,nTake);
    }
}
