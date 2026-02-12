import java.util.*;
public class MazeProblem{
    static int dir[][]={{0,-1},{0,1},{-1,0},{1,0}};
    static char[] move={'L','R','U','D'};
    public static void main(String[] args) {
        int arr[][]={
            {1,0,0,1},
            {1,1,0,1},
            {1,1,0,0},
            {0,1,1,1}
        };
        List<String> ans=new ArrayList<>();
        solve(arr, ans, "", 0, 0);
        System.out.println(ans);
        
    }
    static void solve(int arr[][],List<String> ans,String p,int r,int c)
    {

        if(c<0 || r<0 || r>=arr.length || c>=arr[0].length || arr[r][c]==0)
        {
            return;
        }



        if(r==arr.length-1 && c==arr[0].length-1)
        {
            ans.add(p);
            return;
        }


        arr[r][c]=0;
        for(int i=0;i<4;i++)
        {
           int newR=r+dir[i][0];
           int newC=c+dir[i][1];
           
            solve(arr, ans, p+move[i], newR, newC);
        }
        arr[r][c]=1;



    }
}