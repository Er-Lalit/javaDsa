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
        if(n==1)
        {
            System.out.println(Math.max(arr[0][0], Math.max(arr[0][1],arr[0][2])));
            return;
        }
        
        for(int idx=1;idx<n;idx++)
        {
           arr[idx][0]+=Math.max(arr[idx-1][1], arr[idx-1][2]);
           arr[idx][1]+=Math.max(arr[idx-1][0], arr[idx-1][2]);
           arr[idx][2]+=Math.max(arr[idx-1][0], arr[idx-1][1]);
           Max=Math.max(Max,Math.max(arr[idx][0], Math.max(arr[idx][1], arr[idx][2])));
        }
        System.out.println(Max);
        
        
    }
}