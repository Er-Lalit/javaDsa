// ************* this was the recursion+memo approach *******
// import java.util.*;
// public class Vacations {
//    static int dp[][][];
//     public static void main(String[] args) {
//         Scanner in=new Scanner(System.in);
//         int n=in.nextInt();
//         int arr[]=new int[n];
//         for(int i=0;i<n;i++)
//         {
//             arr[i]=in.nextInt();
//         }
//         dp=new int[n+1][2][2];
//         for(int i=0;i<dp.length;i++)
//         {
//             for(int j=0;j<dp[i].length;j++)
//             {
//                 Arrays.fill(dp[i][j], -1);
//             }
//         }
//         System.out.println(solve(arr,0,0,0));

//     }
//     static int solve(int arr[],int idx,int g, int c)
//     {
//         if(idx==arr.length)
//         {
//             return 0;
//         }
//         if(dp[idx][g][c]!=-1)
//         {
//             return dp[idx][g][c]=-1;
//         }
//         else if(arr[idx]==0)
//         {
//             return dp[idx][g][c]= 1+solve(arr,idx+1,0,0);

//         }
//         else if(arr[idx]==1)
//         {
//             int nTakeG=1+solve(arr,idx+1,0,0);
//             int takec=Integer.MAX_VALUE;
//             if(c!=1)
//             {
//                 takec=solve(arr, idx+1, 0, 1);
//             }
//             return dp[idx][g][c]= Math.min(takec,nTakeG);

//         }
//         else if(arr[idx]==2)
//         {
//             int takeG=Integer.MAX_VALUE;
//             if(g!=1)
//             {
//                 takeG=solve(arr,idx+1,1,0);
//             } 
//             int nTakeC=1+solve(arr,idx+1,0,0);
//             return dp[idx][g][c]= Math.min(takeG,nTakeC);           
//         }
//         else
//         {
//             int takeC=Integer.MAX_VALUE,takeG=Integer.MAX_VALUE;
//             if(c!=1)
//             {
//                 takeC=solve(arr,idx+1,0,1);
//             }
//             if(g!=1)
//             {
//                 takeG=solve(arr,idx+1,1,0);
//             }
//             return dp[idx][g][c]=Math.min(takeC,takeG);
            
//         }
//     }
    
// }

// ***** this is the dp approach *****
import java.util.*;
public class Vacations {
   static int dp[][][];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextInt();
        }
        dp=new int[n+1][2][2];
        for(int i=n-1;i>=0;i--)
        {
            for(int g=0;g<2;g++)
            {
                for(int c=0;c<2;c++)
                {
                    if(arr[i]==0)
                    {
                        dp[i][g][c]=1+dp[i+1][0][0];
                    }
                    else if(arr[i]==1)
                    {
                        int rest=1+dp[i+1][0][0];
                        int contest=Integer.MAX_VALUE;
                        if(c!=1)
                        {
                            contest=dp[i+1][0][1];
                        }
                        dp[i][g][c]=Math.min(rest,contest);
                    }

                    else if (arr[i] == 2) {

                        int gym = Integer.MAX_VALUE;

                        if (g != 1) {
                            gym = dp[i + 1][1][0];
                        }

                        int rest = 1 + dp[i + 1][0][0];

                        dp[i][g][c] = Math.min(gym, rest);

                    }

                    else {

                        int contest = Integer.MAX_VALUE;
                        int gym = Integer.MAX_VALUE;

                        if (c != 1) {
                            contest = dp[i + 1][0][1];
                        }

                        if (g != 1) {
                            gym = dp[i + 1][1][0];
                        }

                        dp[i][g][c] = Math.min(contest, gym);

                    }                    


                }
            }
        }
        System.out.println(dp[0][0][0]);

    }
}
