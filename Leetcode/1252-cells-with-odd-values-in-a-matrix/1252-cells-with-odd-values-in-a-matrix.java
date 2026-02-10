class Solution {
    public int oddCells(int m, int n, int[][] indices) {


 int result[][]=new int[m][n];
      for(int[] a:indices){
        int row=a[0];
        int col=a[1];
        for(int i=0;i<n;i++){
            result[row][i]++;
        }
        for(int j=0;j<m;j++){
            result[j][col]++;
        }
      }
      int count=0;
      for(int i=0;i<result.length;i++){
        for(int j=0;j<result[0].length;j++){
            if(result[i][j]%2!=0){
                count++;
            }
        }
      }
      return count;
    }}