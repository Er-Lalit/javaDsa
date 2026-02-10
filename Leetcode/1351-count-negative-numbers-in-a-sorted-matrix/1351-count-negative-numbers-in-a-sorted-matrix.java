class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        int row=0;
        int col=grid[0].length-1;
        while(row<=grid.length-1&&col>=0){
            if(grid[row][col]<0){
                col--;
                count+=grid.length-row;
            }
            else{
                row++;
            }
        }
        return count;
    }
}