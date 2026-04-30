package Codeforces.KefaandFirstSteps;
import java.util.*;
public class KefaandFirstSteps {
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextInt();
        }
        int dp[]=new int[n];
        Arrays.fill(dp, 1);
        int max=1;
        for(int i=1;i<n;i++)
        {
            if(arr[i]>=arr[i-1])
            {
                dp[i]=dp[i]+dp[i-1];
                max=Math.max(max,dp[i]);
            }
        }
        System.out.println(max);

    }
    
}
