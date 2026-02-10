class Solution {
    public int findTheWinner(int n, int k) {
        // it was the o(n^2) time complexity and using the array 
        // List<Integer> list=new ArrayList<>();
        // for(int i=1;i<=n;i++)
        // {
        //     list.add(i);
        // }
        // int idx=0;
        // while(list.size()>1)
        // {
        //     idx=(idx+(k-1))% list.size();
        //     list.remove(idx);


        // }
        // return list.get(0);
        //from here we can do the concept of the recursion here 
     int ans=findAnswer(n,k);
     return ans+1;

    }
    static int findAnswer(int n,int k)
    {
        if(n==1)
        {
            return 0;
        }
        int idx=findAnswer(n-1,k);
        idx=(idx+k)%n;
        return idx;
    }
}