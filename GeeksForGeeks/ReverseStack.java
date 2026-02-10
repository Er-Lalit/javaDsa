package GeeksForGeeks;
import java.util.*;
public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.addAll(List.of(4,3,2,1));
        System.out.println(st);
        solve(st);
        System.out.println(st);
    
    }
    static void solve(Stack<Integer> st)
    {
        if(st.isEmpty())
        {
            return;
        }
        int temp=st.pop();
        solve(st);
        insertBottom(temp, st);
    }
    static void insertBottom(int num,Stack<Integer> st)
    {
        if(st.isEmpty())
        {
            st.push(num);
            return;

        }
        int temp=st.pop();
        insertBottom(num, st);
        st.push(temp);
    }
    
}
