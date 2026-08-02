package AtCoder.F_LCS;

import java.util.*;

// *** this was the brutforce approach ***

// public class F_LCS {
//     public static void main(String[] args) {
//         Scanner in=new Scanner(System.in);
//         String s1=in.next();
//         String s2=in.next();
//         System.out.println(solve(s1, s2, 0, 0));
//     }
//     static String solve(String s1,String s2,int i,int j)
//     {
//         if(s1.length()==i || s2.length()==j)
//         {
//             return "";
//         }
//         if(s1.charAt(i)==s2.charAt(j))
//         {
//             return s1.charAt(i)+solve(s1,s2,i+1,j+1);
//         }

//         String takeI=solve(s1, s2, i, j+1);
//         String takeJ=solve(s1, s2, i+1,j);
//        return  ( takeI.length()>takeJ.length()) ?takeI : takeJ;
//     }
    
// }

// *** optimized approach ***

public class F_LCS{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s1=in.next();
        String s2=in.next();
        int arr[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<arr.length;i++)
        {
            for(int j=1;j<arr[0].length;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    arr[i][j]=arr[i-1][j-1]+1;
                }
                else
                {
                    arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        String ans="";
        int i=s1.length();
        int j=s2.length();
        while(i>0 && j>0)
        {
            if(s1.charAt(i-1)==s2.charAt(j-1))
            {
                ans=s1.charAt(i-1)+ans;
                i-=1;
                j-=1;
            }
            else
            {
                if(arr[i-1][j]>arr[i][j-1])
                {
                    i=i-1;
                }
                else
                {
                    j=j-1;
                }
            }

        }
        System.out.println(ans);
    }
}
