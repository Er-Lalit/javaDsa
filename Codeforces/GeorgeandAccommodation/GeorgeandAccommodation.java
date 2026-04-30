package Codeforces.GeorgeandAccommodation;
import java.util.*;
public class GeorgeandAccommodation {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int count=0;
        for(int i=0;i<n;i++)
        {
            int p=in.nextInt();
            int q=in.nextInt();
            if(q-p>=2)
            {
                count++;
            }
        }
        System.out.println(count);
    }
}
