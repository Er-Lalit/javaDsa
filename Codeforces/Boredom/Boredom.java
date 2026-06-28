//  1 recursive approach 
// package Codeforces.Boredom;
// import java.util.*;
// public class Boredom {
//    static long points[];
//    static int maxValue;
//    static long dp[];
//     public static void main(String[] args) {
//         Scanner in=new Scanner(System.in);
//         int n=in.nextInt();
//         points=new long[100001];
//         dp=new long[100001];
//         Arrays.fill(dp,-1);
//         maxValue=Integer.MIN_VALUE;
//         for(int i=0;i<n;i++)
//         {
//             int x=in.nextInt();
//             points[x]+=x;
//             maxValue=Math.max(maxValue, x);
//         }
//         System.out.println(solve(1));

        
//     }
//     static long solve(int i)
//     {
//         if(i>maxValue)
//         {
//             return 0;
//         }
//         if(dp[i]!=-1)
//         {
//             return dp[i];
//         }
//         // take
//         long take=points[i]+solve(i+2);
//         long notTake=solve(i+1);
//         return dp[i]= Math.max(take, notTake);

//     }
// }

// 2 dp approach

package Codeforces.Boredom;
import java.util.*;
public class Boredom 
{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int maxValue=0;
        long points[]=new long[100001];
        for(int i=0;i<n;i++)
        {
            int x=in.nextInt();
            points[x]+=x;
            maxValue=Math.max(x,maxValue);
        }
        long ans=Math.min
        long dp[]=new long[maxValue+3];
        for(int i=maxValue;i<=0;i--)
        {
            
        }
    }
}

