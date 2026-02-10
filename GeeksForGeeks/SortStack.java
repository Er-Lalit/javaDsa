
package GeeksForGeeks;
import java.util.*;

public class SortStack {
    public static void main(String args[])
    {
        Stack<Integer> st=new Stack<>();
        st.addAll(List.of(41,3,32,2,11));
        solve(st);
        System.out.println(st);
        System.out.println(st.pop());

    } 
    static void solve(Stack<Integer> st)
    {
        if(st.isEmpty())
        {
            return;
        }
        int temp=st.pop();
        solve(st);
        sortRecursion(temp, st);

    }
    static void sortRecursion(int num,Stack<Integer> st)
    {
        if(st.isEmpty())
        {
            st.push(num);
            return ;
        }
        if(num>=st.peek())
        {
            st.push(num);
            return ;
        }
        int temp=st.pop();
        sortRecursion(num, st);
        st.push(temp);
       
        
    }
}
