class Solution {

    static final long MOD = 1_000_000_007L;

    public int numberOfWays(String s, String t, long k) {

        int n = s.length();

        // Count how many rotations of s are equal to t
        int cnt0 = 0; // matching rotation 0
        int cnt1 = 0; // matching non-zero rotations

        // s + s contains all rotations of s
        String text = s + s;

        // KMP / string matching
        int[] lps = buildLPS(t);

        int j = 0;

        for (int i = 0; i < text.length(); i++) {

            while (j > 0 && text.charAt(i) != t.charAt(j)) {
                j = lps[j - 1];
            }

            if (text.charAt(i) == t.charAt(j)) {
                j++;
            }

            if (j == n) {

                int start = i - n + 1;

                // Only rotations 0 ... n-1
                if (start < n) {

                    if (start == 0) {
                        cnt0++;
                    } else {
                        cnt1++;
                    }
                }

                j = lps[j - 1];
            }
        }

        /*
         * Matrix:
         *
         * [A']   [ 0       n-1 ] [A]
         * [B'] = [ 1       n-2 ] [B]
         *
         * A = ways to reach rotation 0
         * B = ways to reach any particular non-zero rotation
         *
         * Initially:
         * A = 1
         * B = 0
         */

        long[][] matrix = {
            {0, n - 1},
            {1, n - 2}
        };

        long[][] result = matrixPower(matrix, k);

        // Initial vector = [1, 0]
        //
        // Therefore after k operations:
        //
        // A = result[0][0]
        // B = result[1][0]

        long waysRotation0 = result[0][0];
        long waysNonZero = result[1][0];

        long answer =
            (cnt0 * waysRotation0 +
             cnt1 * waysNonZero) % MOD;

        return (int) answer;
    }


    // Build LPS array for KMP
    private int[] buildLPS(String pattern) {

        int n = pattern.length();

        int[] lps = new int[n];

        int len = 0;

        for (int i = 1; i < n; i++) {

            while (len > 0 &&
                   pattern.charAt(i) != pattern.charAt(len)) {

                len = lps[len - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
            }

            lps[i] = len;
        }

        return lps;
    }


    // Matrix exponentiation
    private long[][] matrixPower(long[][] base, long exp) {

        long[][] result = {
            {1, 0},
            {0, 1}
        };

        while (exp > 0) {

            if ((exp & 1) == 1) {
                result = multiply(result, base);
            }

            base = multiply(base, base);

            exp >>= 1;
        }

        return result;
    }


    // Multiply two 2x2 matrices
    private long[][] multiply(long[][] a, long[][] b) {

        long[][] c = new long[2][2];

        c[0][0] = (
            a[0][0] * b[0][0] +
            a[0][1] * b[1][0]
        ) % MOD;

        c[0][1] = (
            a[0][0] * b[0][1] +
            a[0][1] * b[1][1]
        ) % MOD;

        c[1][0] = (
            a[1][0] * b[0][0] +
            a[1][1] * b[1][0]
        ) % MOD;

        c[1][1] = (
            a[1][0] * b[0][1] +
            a[1][1] * b[1][1]
        ) % MOD;

        return c;
    }
}