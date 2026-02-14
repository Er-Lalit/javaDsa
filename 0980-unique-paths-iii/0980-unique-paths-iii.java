class Solution {
    static int dir[][]={{0,-1},{0,1},{-1,0},{1,0}};
    public int uniquePathsIII(int[][] grid) {
        int count=0;
        int row=0;
        int col=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==-1)
                {
                    count+=1;

                }
                if(grid[i][j]==1)
                {
                    row=i;
                    col=j;
                }
                
            }
        }
        int tCell=grid.length*grid[0].length;
        // here we can not include the destination here 
        tCell=tCell-count-1;
        return solve(row,col,tCell,grid);
    }
    static int solve(int row,int col,int tCell,int[][] grid)
    {
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==-1)
        {
            return 0;
        }
        if(grid[row][col]==2)
        {
            return tCell==0?1:0;
        }
        grid[row][col]=-1;
        tCell-=1;
        int count=0;
        for(int i=0;i<dir.length;i++)
        {
            int nRow=row+dir[i][0];
            int nCol=col+dir[i][1];
            count+=solve(nRow,nCol,tCell,grid);
        }
        grid[row][col]=0;
        tCell+=1;
        return count;


    }
}