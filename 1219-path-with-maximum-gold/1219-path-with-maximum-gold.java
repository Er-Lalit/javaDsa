class Solution {
    static int direction[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public int getMaximumGold(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int max=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                max=Math.max(max,maxGold(i,j,grid,n,m));

            }
        }
        return max;
        
    }
    static int maxGold(int i,int j,int[][] grid,int n,int m)
    {
        if( i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == 0) 
        {
            return 0;
        }
        int originalVal=grid[i][j];
        grid[i][j]=0;
        int maxgold=0;

        for(int arr[]:direction)
        {
            int newI=i+arr[0];
            int newJ=j+arr[1];
            maxgold=Math.max(maxgold,maxGold(newI,newJ,grid,n,m));
        }
        grid[i][j]=originalVal;
        return maxgold+originalVal;

    }

}