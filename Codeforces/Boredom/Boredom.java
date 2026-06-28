package Codeforces.Boredom;
import java.util.*;
public class Boredom {
   static int points[];
   static int maxValue;
   static int dp[];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        points=new int[100001];
        dp=new int[100001];
        Arrays.fill(dp,-1);
        maxValue=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int x=in.nextInt();
            points[x]+=x;
            maxValue=Math.max(maxValue, x);
        }
        System.out.println(solve(1));

        
    }
    static int solve(int i)
    {
        if(i>maxValue)
        {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        // take
        int take=points[i]+solve(i+2);
        int notTake=solve(i+1);
        return dp[i]= Math.max(take, notTake);

    }
}
