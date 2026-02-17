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
    

    /*
     * Complete the 'arithmeticExpressions' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String arithmeticExpressions(List<Integer> arr) {
    // Write your code here
    int total=arr.get(0);
     boolean visited[][]=new boolean[arr.size()][101];
    return solve(total%101, arr, 1,""+arr.get(0),visited);
    

    }
    public static String solve(int remainder,List<Integer> arr,int i,String s,boolean[][] visited)
    {
        if(i==arr.size())
        {
         if(remainder==0)
         {
           return s;
         }
         return "";
       }
       if(visited[i][remainder])
       {
        return "";
       }
       visited[i][remainder]=true;
       // for +
        int next=(remainder+arr.get(i))%101;
        String s1=solve(next, arr, i+1,s+"+"+arr.get(i),visited);
        if(!s1.equals(""))
        {
            return s1;
        }
        //for -
       next=(remainder-arr.get(i))%101;  
       if(next<0) next=(next+101)%101;     
       s1=solve(next, arr, i+1,s+"-"+arr.get(i),visited);
       if(!s1.equals(""))
       {
        return s1;
       }
       next=(remainder*arr.get(i))%101;
       s1=solve(next, arr, i+1,s+"*"+arr.get(i),visited);
       if(!s1.equals(""))
       {
        return s1;
       }
       return "";
        
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String result = Result.arithmeticExpressions(arr);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
