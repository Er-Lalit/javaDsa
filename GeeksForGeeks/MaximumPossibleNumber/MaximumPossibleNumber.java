

class Solution {
    static String max;
    // Function to find the largest number after k swaps.
    public String findMaximumNum(String s, int k) {
        // code here.
        max=s;
        solve(s,k,0);
        return max;
    }
    static void solve(String s,int k,int idx)
    {
        if(k==0 || idx==s.length())
        {
            return ;
        }
        char maxChar=s.charAt(idx);
        for(int i=idx+1;i<s.length();i++)
        {
            if(maxChar<s.charAt(i))
            {
                maxChar=s.charAt(i);
            }
        }
        if(maxChar!=s.charAt(idx))
        {
            k=k-1;
            for(int j=idx;j<s.length();j++)
            {
                if(s.charAt(j)==maxChar)
                {
                    String swaped=swap(s,idx,j);
                    if(swaped.compareTo(max)>0)
                {
                    max=swaped;
                }
                    solve(swaped,k,idx+1);
                }
            }
        }
        else
        {
            solve(s,k,idx+1);
        }
    }
    // this is was the brutforce approach
    // static void solve(String s,int k)
    // {
    //     if(max==null || s.compareTo(max)>0)
    //     {
    //         max=s;
    //     }
    //     if(k==0)
    //     {
    //         return;
    //     }
        
    //     for(int i=0;i<s.length()-1;i++)
    //     {
    //         for(int j=i+1;j<s.length();j++)
    //         {
    //             if(s.charAt(i)<s.charAt(j))
    //             {
    //                 String swaped=swap(s,i,j);
    //                 solve(swaped,k-1);
    //             }
    //         }
    //     }
    // }
    static String swap(String s,int i,int j)
{
    //if(i == j) return s;  // ✅ fix

    String left = s.substring(0,i);
    char iTh = s.charAt(i);
    String middle = s.substring(i+1,j);
    char jTh = s.charAt(j);
    String last = s.substring(j+1);
    return left + jTh + middle + iTh + last;
}
}