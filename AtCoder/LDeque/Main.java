    package AtCoder.LDeque;

    import java.util.*;

    public class Main{
        static int arr[];
        static int n;
        static int dp[][];
        public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            n=in.nextInt();
            arr=new int[n];
            dp=new int[n+1][n+1];
            for(int i=0;i<dp.length;i++)
            {
                Arrays.fill(dp[i],-1);
            }

            long total=0;
            for(int i=0;i<n;i++)
            {
                arr[i]=in.nextInt(); 
                total+=arr[i];           
            }
            System.out.println(solve(0, n-1));

        }
        static int solve(int start,int end)
        {
            if(start>end)
            {
                return 0;
            }
            if(dp[start][end]!=-1)
            {
                return dp[start][end];
            }
            int left=arr[start]-solve(start+1,end);
            int right=arr[end]-solve(start,end-1);
            return dp[start][end]=Math.max(left, right);


        }
    }