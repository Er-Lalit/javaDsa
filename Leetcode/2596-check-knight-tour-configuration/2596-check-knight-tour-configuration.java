class Solution {
    static int dir[][]={
        {2,-1},{2,1},{-1,2},{1,2},{-2,1},{-2,-1},{-1,-2},{1,-2}
    };
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0)
        {
            return false;
        }
        int size=grid.length*grid[0].length;
        return solve(1,0,0,grid,size);
        
    }
    static boolean solve(int count,int row,int col,int[][] grid,int size)
    {
        if(count==size)
        {
            return true;
        }
        List<Integer> ls=knightR(count,row,col,grid);
        if(ls==null){
            return false;
        }
        return solve(count+1,ls.get(0),ls.get(1),grid,size);
        



    }
    static List<Integer> knightR(int count,int row,int col,int[][] grid)
    {
        for(int arr[]:dir)
        {
            int nRow=row+arr[0];
            int nCol=col+arr[1];
            if(nRow<0 || nRow>=grid.length || nCol<0 || nCol>=grid[0].length)
            {
                continue;
            }
            else
            {
                if(grid[nRow][nCol]==count)
                {
                    return new ArrayList(List.of(nRow,nCol));
                }
            }
        }
        return null;

    }
}