class Solution {
//    static boolean dp[][];
//     public int countSubstrings(String s) {
//         dp=new boolean[s.length()+1][s.length()+1];

//         int count=0;
//         for(int i=0;i<s.length();i++)
//         {
//             for(int j=i;j<s.length();j++)
//             {
//                 if(check(i,j,s))
//                 {
//                     count+=1;
//                 }
//             }
//         }
//         return count;
//     }  
//     static boolean check(int i ,int j,String s)
//     {
//         if(i>=j)
//         {
//             return true;
//         }
//         if(dp[i][j]!=false)
//         {
//             return dp[i][j];
//         }
//         if(s.charAt(i)==s.charAt(j))
//         {
//             return dp[i][j]=check(i+1,j-1,s);
//         }
//         else
//         {
//             return dp[i][j]=false;
//         }
        
//     }  
public int countSubstrings(String s) {
    boolean dp[][]=new boolean[s.length()][s.length()];
    int count=0;
    int j=0;
    for(int l=1;l<=s.length();l++)
    {
        for(int i=0;l+i-1<s.length();i++)
        {
            j=l+i-1;
            if(i==j)
            {
                dp[i][j]=true;
            }
            else if(i+1==j)
            {
                dp[i][j]=(s.charAt(i)==s.charAt(j));
            }
            else
            {
                dp[i][j]=(dp[i+1][j-1] && s.charAt(i)==s.charAt(j));
            }
            if(dp[i][j]==true)
            {
                count++;
            }
        }
    }
    return count;
}

}