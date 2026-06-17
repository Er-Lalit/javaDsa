package AtCoder.C_Vacation;
import java.util.*;
public class C_Vacation{
    static int Max=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int arr[][]=new int[n][3];
        for(int i=0;i<n;i++)
        {
            arr[i][0]=in.nextInt();
            arr[i][1]=in.nextInt();
            arr[i][2]=in.nextInt();
            
        }
        solve(0, arr, 0, false, false, false);
        System.out.println(Max);

        
    }
    static void solve(int sum,int arr[][],int idx,boolean f1,boolean f2,boolean f3)
    {
        if(idx==arr.length)
        {
            Max=Math.max(sum, Max);
            return;
        }
        for(int i=0;i<3;i++)
        {
            if(i==0 && f1 || i==1 && f2 || i==2 && f3)
            {
                continue;
            }
            boolean Nf1=false;
            boolean Nf2=false;
            boolean Nf3=false;
            if(i==0)
            {
                Nf1=true;
            }
            else if(i==1)
            {
                Nf2=true;
            }
            else
            {
                Nf3=true;
            }
            solve(sum+arr[idx][i],arr, idx+1, Nf1, Nf2, Nf3);
           
        }
    }
}