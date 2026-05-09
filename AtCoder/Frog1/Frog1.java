package AtCoder.Frog1;
import java.util.*;

class Frog1 {

    static int dp[];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        dp = new int[n];

        Arrays.fill(dp, -1);

        int arr[] = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solve(arr, 0));
    }

    static int solve(int arr[], int i) {

        if(i == arr.length - 1) {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int i1 = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;

        if(i + 1 < arr.length) {
            i1 = Math.abs(arr[i] - arr[i + 1]) + solve(arr, i + 1);
        }

        if(i + 2 < arr.length) {
            i2 = Math.abs(arr[i] - arr[i + 2]) + solve(arr, i + 2);
        }

        return dp[i] = Math.min(i1, i2);
    }
}