
import java.util.*;

public class PrimePWithSumS {
    public static void main(String[] args) {
        int s=23;
        int p=2;
        int n=3;
        boolean arr[]=new boolean[28+1];
        findPrimeNumbers(s, arr);
        List<Integer> prime=new ArrayList<>();
        for(int i=p;i<s;i++)
        {
            if(arr[i]==false)
            {
                prime.add(i);
            }
        }
        Stack<Integer> st=new Stack<>();
        List<List<Integer>> ans=new ArrayList<>();
        solve(st, ans, n, 0, s,prime);
        System.out.println(ans);

        
    }
    static void findPrimeNumbers(int s,boolean arr[])
    {
        for(int i=2;i<s;i++)
        {
            if(arr[i]==true)
            {
                continue;
            }
            for(int j=i*2;j<s;j=j+i)
            {
                arr[j]=true;

            }
        }
        
    }
    static void solve(Stack<Integer> st,List<List<Integer>> ans,int n,int idx,int sum,List<Integer> prime)
    {
        if(sum==0 && n==0)
        {
            ans.add(new ArrayList(st));
            return ;
        }
        if(sum<0 || n<0)
        {
            return;
        }
        for(int i=idx;i<prime.size();i++)
        {
            st.push(prime.get(i));
            solve(st, ans, n-1, i+1, sum-prime.get(i), prime);
            st.pop();
        }
            
    }
}
