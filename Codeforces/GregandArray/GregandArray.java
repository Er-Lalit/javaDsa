package Codeforces.GregandArray;

import java.util.*;
public class GregandArray
{
   public static void main(String args[])
   {
      Scanner in=new Scanner(System.in);
      // here n is number of element in array m is the number of the operation and k is the number of queries
      int n=in.nextInt();
      int m=in.nextInt();
      int k=in.nextInt();
      long arr[]=new long[n];
      for(int i=0;i<n;i++)
      {
         arr[i]=in.nextLong();
      }
      int oper[][]=new int[m][3];
      for(int i=0;i<m;i++)
      {
         oper[i][0]=in.nextInt();
         oper[i][1]=in.nextInt();
         oper[i][2]=in.nextInt();
      }
      int querie[][]=new int[k][2];
      for(int i=0;i<k;i++)
      {
         querie[i][0]=in.nextInt();
         querie[i][1]=in.nextInt();
      }
      int max=0;
      for(int i=0;i<m;i++)
      {
         max=Math.max(max,oper[i][0]);
         max=Math.max(max,oper[i][1]);
         max=Math.max(max,oper[i][2]);
 
      }
      for(int i=0;i<k;i++)
      {
         max=Math.max(max,querie[i][0]);
         max=Math.max(max,querie[i][1]);
      }
      long qPrefix[]=new long[max+2];
      for(int i=0;i<k;i++)
      {
          qPrefix[querie[i][0]]+=1;
          qPrefix[querie[i][1]+1]-=1;
 
         
      }
      for(int i=1;i<qPrefix.length;i++)
      {
          qPrefix[i]= qPrefix[i]+ qPrefix[i-1];
          
         
      }
      long oPrefix[]=new long[max+2];
      for(int i=0;i<m;i++)
      {      
         long count=qPrefix[i+1];
         int l=oper[i][0];
         int r=oper[i][1];
         int d=oper[i][2];
         oPrefix[l]+=d*count;
         oPrefix[r+1]-=d*count;
 
  
         
      }
      for(int i=1;i<oPrefix.length;i++)
      {
          oPrefix[i]= oPrefix[i]+ oPrefix[i-1];
         
      }
 
 
 
       
 
      for(int i = 0; i < n; i++)
      {
         arr[i] = arr[i] + oPrefix[i + 1];
      }
      for(int i = 0; i < n; i++)
      {
         System.out.print(arr[i] + " ");
      }
      
            
   }
}