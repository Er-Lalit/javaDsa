package GeeksForGeeks.HamiltonianCycle;

import java.util.*;
public class HmiltonionCycle {
    public static void main(String[] args) {
        int mat[][]=
        {
  {0,1,1,0},
    {1,0,1,0},
    {1,1,0,0},
    {0,0,0,0}
        };
        boolean visited[]=new boolean[mat.length];
        for(int i=0;i<mat.length;i++)
        {
            if(solve(i, i, mat, mat.length, 0, visited))
            {
                System.out.println("path exist");
                return;
            }
        }
        System.out.println("path not exist");

        
    }
  static boolean solve(int start,int node,int mat[][],int n,int count,boolean[] visited)
    {
        visited[node]=true;
        count++;
        if(count==n)
        {
            if(mat[node][start]==1)
            {
               return true;
            }
            return false;   
        }
        for(int j=0;j<mat[node].length;j++)
        {
            if(mat[node][j]==1 && !visited[j])
            {
                if(solve(start,j,mat,n,count,visited))
                {
                    return true;
                }
            }
        }
        visited[node]=false;
        count--;
        return false;
        
    }
}
