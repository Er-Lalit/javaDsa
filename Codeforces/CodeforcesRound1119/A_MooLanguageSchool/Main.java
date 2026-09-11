import  java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=in.nextInt();
            int k=in.nextInt();
            String s=in.next();
            System.out.println(solve(s, n, k));
            
        }
 
    }
    static int solve(String s,int n,int k)
    {
        int count=0;
        int i=0;
        while(i<n)
        {
            int j=k;
            int count1=0;
            while(j>0)
            {
                if(s.charAt(i)=='1')
                {
                    count1++;
                }
                j--;
                i++;
            }
            if(count1==k)
            {
                count++;
            }
        }
        return count;
 
    }
}