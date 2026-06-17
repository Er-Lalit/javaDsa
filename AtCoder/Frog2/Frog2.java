package AtCoder.Frog2;
import java.util.*;
public class Frog2 {
    static int dp[];

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextInt();

        }
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(sovle(0, n, k, arr));
    }
    static int sovle(int idx,int n, int k,int arr[])
    {
        if(idx==n-1)
        {
            return 0;
        }
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=idx+1;i<=idx+k && i<n;i++)
        {
            ans=Math.min(ans,Math.abs(arr[i]-arr[idx])+sovle(i, n, k, arr));
        }
        return dp[idx]= ans;
    }
    
}
