package Codeforces.BasketballExercise;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    static long arr1[];
    static long arr2[];
    static long dp[][];
    static int n;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        arr1=new long[n];
        arr2=new long[n];
        dp=new long[n][3];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i], -1);
        }
        for(int i=0;i<n;i++)
        {
            arr1[i]=in.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            arr2[i]=in.nextInt();
        }
        System.out.println(solve(0, 2));

    }
    static long solve(int i, int prev)
    {
        if(i==n)
        {
            return 0;
        }
        if(dp[i][prev]!=-1)
        {
            return dp[i][prev];
        }

        long take1=0;
        if(prev!=0)
        {
            take1= arr1[i]+solve(i+1, 0);
        }

        long take2=0;
        if(prev!=1)
        {
            take2=arr2[i]+solve(i+1, 1);
            
        }

        long takeNeither=solve(i+1,2);

        return dp[i][prev]= Math.max(take1,Math.max(take2,takeNeither));
    }
    
}
