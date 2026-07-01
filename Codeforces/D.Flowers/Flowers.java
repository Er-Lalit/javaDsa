import java.util.*;

public class Flowers {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        int k = in.nextInt();

        int[] a = new int[t];
        int[] b = new int[t];

        int maxB = 0;

        for (int i = 0; i < t; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            maxB = Math.max(maxB, b[i]);
        }

        int[] dp = new int[maxB + 1];
        int[] pref = new int[maxB + 1];

        dp[0] = 1;

        for (int i = 1; i <= maxB; i++) {
            dp[i] = dp[i - 1];

            if (i >= k) {
                dp[i] = (dp[i] + dp[i - k]) % MOD;
            }
        }

        pref[0] = dp[0];

        for (int i = 1; i <= maxB; i++) {
            pref[i] = (pref[i - 1] + dp[i]) % MOD;
        }

        for (int i = 0; i < t; i++) {
            int ans = pref[b[i]];

            if (a[i] > 0) {
                ans = (ans - pref[a[i] - 1] + MOD) % MOD;
            }

            System.out.println(ans);
        }
    }
}