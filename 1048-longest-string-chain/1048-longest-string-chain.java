class Solution {
    static int dp[][];
    public int longestStrChain(String[] words) {
        dp=new int[words.length][words.length+1];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        Arrays.sort(words,new MyComparable());
        return recursive(0,words,-1);

        
    }
    static int recursive(int idx, String arr[],int pIdx)
    {
        if(idx==arr.length)
        {
            return 0;
        }
        
        if(dp[idx][pIdx+1]!=-1)
        {
            return dp[idx][pIdx+1];
        }
        int take=0;
        if(pIdx==-1 || predecessor(idx,pIdx, arr))
        {

            take=1+recursive(idx+1,arr,idx);
            

        }
        int skip=recursive(idx+1,arr,pIdx);

        return dp[idx][pIdx+1]=Math.max(take,skip);
    }

    static boolean predecessor(int idx, int pIdx,String arr[])
    {
        String s1=arr[pIdx];
        String s2=arr[idx];
        if(s1.length()+1!=s2.length())
        {
            return false;
        }
        int i=0;
        int j=0;
        while(s1.length()>i && s2.length()>j)
        {
            if(s1.charAt(i)==s2.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                j++;
            }
        }
        return s1.length()==i ;
        
    }
}
public class MyComparable implements Comparator<String>
{
    public int compare(String s1,String s2)
    {
        return s1.length()-s2.length();
    }
}