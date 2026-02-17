package GeeksForGeeks.NewHappyNumber;
import java.util.*;
class Solution {

    static int nextHappy(int N) {
        // code here
        N++;
        while(true)
        {
            if(solve(N))
            {
                return N;
            }
            else
            {
                N++;
            }
        }
    }
    static boolean solve(int N)
    {
        Set<Integer> s=new HashSet<>();
        if(N==1 || N==7)
        {
            return true;
        }
        if(N<=9)
        {
            return false;
        }
        if(s.contains(N))
        {
            return false;
        }
        s.add(N);
        int sum=0;
        while(N>0)
        {
            int d=N%10;
            sum+=d*d;
            N=N/10;
            
        }
        return solve(sum);
    }
}    