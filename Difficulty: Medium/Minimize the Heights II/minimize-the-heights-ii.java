import java.util.*;

class Solution {
    public int getMinDiff(int[] arr, int k) {

        int n = arr.length;

        // If only one tower, difference is 0
        if (n == 1) return 0;

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Initial difference
        int ans = arr[n - 1] - arr[0];

        // Step 3: Fix smallest and largest after operation
        int small = arr[0] + k;
        int big = arr[n - 1] - k;

        // Step 4: Try all partitions
        for (int i = 1; i < n; i++) {

            // Skip if height becomes negative
            if (arr[i] - k < 0) continue;

            int mini = Math.min(small, arr[i] - k);
            int maxi = Math.max(big, arr[i - 1] + k);

            ans = Math.min(ans, maxi - mini);
        }

        return ans;
    }
}