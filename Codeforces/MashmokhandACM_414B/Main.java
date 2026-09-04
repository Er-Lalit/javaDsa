    package Codeforces.MashmokhandACM_414B;
    import java.util.*;
    public class Main {
        static int n;
        static long dp[][];
        public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            n=in.nextInt();
            int k=in.nextInt();
            dp=new long[n+1][k+1];
            for(int i=0;i<dp.length;i++)
            {
                Arrays.fill(dp[i],-1);
            }
            long ans=0;
            for(int i=1;i<=n;i++)
            {
            ans=(ans+ sovle(i,k-1)) % 1000000007;

            }
            System.out.println(ans);
            

        }

        static long sovle(int current,int length)
        {
            if(length==0)
            {
                return 1;
            }
            if(dp[current][length]!=-1)
            {
                return dp[current][length];
            }
            long ans=0;
            for(int i=current;i<=n; i += current)
            {
                if(i%current==0)
                {
                    ans=(ans+sovle(i,length-1)) % 1000000007 ;

                }
            }
            return dp[current][length]=ans;

        }
        
    }
