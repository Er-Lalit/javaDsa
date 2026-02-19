package HackerRank.KFactorization;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

static int maxSate=Integer.MAX_VALUE;
static Map<Long,Integer> map=new HashMap<>();
    /*
     * Complete the 'kFactorization' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY A
     */

    public static List<Integer> kFactorization(int n, List<Integer> A) {
    // Write your code 
    List<List<Integer>> ans=new ArrayList<>();
    Stack<Integer> st=new Stack<>();
    
    solve(ans, A, st, n, 0, 1);
    if(ans.isEmpty())
    {
        return List.of(-1);
    }
    return ans.get(ans.size()-1);

    }
    static void solve(List<List<Integer>> ans,List<Integer> A,Stack<Integer> st,int n,int state,long destination)
    {
        if(destination>n)
        {
            return;
        }
        
        if(state>maxSate)
        {
            return;
        }
          if(map.containsKey(destination) && map.get(destination) == state)
          return;

        map.put(destination, state);
        st.push((int)destination);
        if(n==destination)
        {
            if(state<maxSate)
            {
            
            ans.add(new ArrayList<>(st));
            maxSate=state;
            }
            
        }
        for(int i=0;i<A.size();i++)
        {
            solve(ans, A, st, n, state+1, destination*A.get(i));
            
        }
        st.pop();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.kFactorization(n, A);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
