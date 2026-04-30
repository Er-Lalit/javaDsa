package Codeforces.KarenandCoffee;

import java.util.*;
class KarenandCoffee
{


class Main
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
 
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
 
        int[][] recipe = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            recipe[i][0] = in.nextInt();
            recipe[i][1] = in.nextInt();
        }
 
        int[][] question = new int[q][2];
        for(int i = 0; i < q; i++)
        {
            question[i][0] = in.nextInt();
            question[i][1] = in.nextInt();
        }
 
        int max = 0;
 
        for(int i = 0; i < n; i++)
        {
            max = Math.max(max, recipe[i][0]);
            max = Math.max(max, recipe[i][1]);
        }
 
        for(int i = 0; i < q; i++)
        {
            max = Math.max(max, question[i][0]);
            max = Math.max(max, question[i][1]);
        }
 
        int[] prefix = new int[max + 2];
 
        for(int i = 0; i < n; i++)
        {
            prefix[recipe[i][0]] += 1;
            if(recipe[i][1] + 1 < prefix.length)
            {
                prefix[recipe[i][1] + 1] -= 1;
            }
        }
 
        for(int i = 1; i < prefix.length; i++)
        {
            prefix[i] = prefix[i] + prefix[i - 1];
        }
        int good[]=new int[prefix.length];
        for(int i=0;i<prefix.length;i++)
        {
           if(prefix[i]>=k)
           {
              good[i]=1;
            }
           
        }
        for(int i=1;i<good.length;i++)
        {
           good[i]=good[i]+good[i-1];
        }
        for(int i=0;i<question.length;i++)
        {
           int a=question[i][0];
           int b=question[i][1];
           System.out.println(good[b]-good[a-1]);
        }
        
 
            }
}
}