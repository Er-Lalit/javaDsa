package GeeksForGeeks.KnightsTour;

import java.util.Arrays;
import java.util.List;

class KnightsTour
{
    static int dir[][]={
        {2,-1},{2,1},{-1,2},{1,2},{-2,1},{-2,-1},{-1,-2},{1,-2}
    };

    public static void main(String[] args) {
        int[][] grid=new int[5][5];
        solve(0, 0, 0, grid, 25);
        System.out.println(Arrays.deepToString(grid));
        
    }
    static boolean solve(int count,int row,int col,int[][] grid,int size)
    {
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length ||grid[row][col]!=0)
        {
            return false;
        }
        grid[row][col]=count;
        if(count==size-1)
        {
            return true;
        }
        for(int arr[]:dir)
        {
            int nRow=row+arr[0];
            int nCol=col+arr[1];
            if(solve(count+1, nRow, nCol, grid, size))
            {
                return true;
            }

        }
        grid[row][col]=0;
        return false;
        


    }
}