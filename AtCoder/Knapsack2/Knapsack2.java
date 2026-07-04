// *** recursive and the memo approach ***

// package AtCoder.Knapsack2;

// import java.util.*;

// public class Knapsack2 {
//     static int wait[];
//     static int value[];
//     static long dp[][];

//     public static void main(String args[]) {
//         Scanner in = new Scanner(System.in);
//         int n = in.nextInt();
//         int w = in.nextInt();
//         wait = new int[n];
//         value = new int[n];
//         int valueNeed = 0;
//         for (int i = 0; i < n; i++) {
//             wait[i] = in.nextInt();
//             value[i] = in.nextInt();
//             valueNeed += value[i];
//         }
//         int ans = 0;
//         dp=new long[n+1][valueNeed+1];
//         for(int i=0;i<dp.length;i++)
//         {
//             Arrays.fill(dp[i],-1);
//         }
//         for (int i = valueNeed; i >= 0; i--) {
//             long requiredWait = solve(0, i);
//             if (requiredWait <= w) {
//                 ans = i;
//                 break;

//             }
//         }
//         System.out.println(ans);

//     }

//     static long solve(int idx, int valueN) {
//         if (valueN == 0) {
//             return 0;
//         }
//         if (idx == wait.length) {
//             return Long.MAX_VALUE;
//         }
//         if(dp[idx][valueN]!=-1)
//         {
//             return dp[idx][valueN];
//         }
//         long take = Long.MAX_VALUE;

//         if (valueN >= value[idx]) {
//             long temp = solve(idx + 1, valueN - value[idx]);

//             if (temp != Long.MAX_VALUE) {
//                 take = wait[idx] + temp;
//             }
//         }
//         long nTake = solve(idx + 1, valueN);

//         return dp[idx][valueN]=Math.min(take, nTake);

//     }
// }

//*** bottom up aaproach ***

package AtCoder.Knapsack2;

import java.util.*;

public class Knapsack2 {
    static int wait[];
    static int value[];
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();
        wait = new int[n];
        value = new int[n];
        int valueNeed = 0;
        for (int i = 0; i < n; i++) {
            wait[i] = in.nextInt();
            value[i] = in.nextInt();
            valueNeed += value[i];
        }
        long[][] dp=new long[n+1][valueNeed+1];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],Long.MAX_VALUE);
        }
        // don't forget this line this is the also the base case
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=0;
        }
        for(int i=n-1;i>=0;i--)
        {
            for(int v=0;v<=valueNeed;v++)
            {
                long nTake=dp[i+1][v];
                long take=Long.MAX_VALUE;
                if(v>=value[i])
                {
                    if(dp[i+1][v-value[i]]!=Long.MAX_VALUE)
                    {
                        take=wait[i]+dp[i+1][v-value[i]];

                    }
                }
                dp[i][v]=Math.min(take,nTake);

            }

        }
        int ans=0;
        for(int v=valueNeed;v>=0;v--)
        {
            if(dp[0][v]<=w)
            {
                ans=v;
                break;
            }
        }
        System.out.println(ans);
    }
}