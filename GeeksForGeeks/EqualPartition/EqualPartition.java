package GeeksForGeeks.EqualPartition;

import java.util.*;
public class EqualPartition{
    public static void main(String[] args) {
        int arr[]={2, 1, 4, 5, 3, 3};
        int total=0;
        for(int i=0;i<arr.length;i++)
        {
            total+=arr[i];

        }
        Stack<Integer> st=new Stack<>();
        Set<List<Integer>> ans=new HashSet<>();
        if(arr.length%2==0)
        {
         evenSolution(arr.length,total/2, 0, arr, st, ans);
        }
        else{
          oddSolution(arr.length, total/2, 0, arr, st, ans);
        }
        System.out.println(ans);
        
    }
    static void evenSolution(int element,int total,int idx,int arr[],Stack<Integer> st,Set<List<Integer>> ans)
    {
        if(element==arr.length/2 && total==0)
        {
            ans.add(new ArrayList(st));
            return ;

        }
        if(idx==arr.length || element<0 || total<0)
        {
            return;
        }
        for(int i=idx;i<arr.length;i++)
        {
            st.push(arr[i]);
            evenSolution(element-1, total-arr[i], i+1, arr, st, ans);
            st.pop();
        }
    }
        static void oddSolution(int element,int total,int idx,int arr[],Stack<Integer> st,Set<List<Integer>> ans)
    {
        if((element==arr.length/2 && total==0) || (element==(arr.length+1)/2 && total==0))
        {
            ans.add(new ArrayList(st));
            return ;

        }
        if(idx==arr.length || element<0 || total<0)
        {
            return;
        }
        for(int i=idx;i<arr.length;i++)
        {
            st.push(arr[i]);
            oddSolution(element-1, total-arr[i], i+1, arr, st, ans);
            st.pop();
        }
    }
}