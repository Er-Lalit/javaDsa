class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][]=new int[n][n];
        int num=1;
        int sRow=0;
        int sCol=0;
        int endRow=n-1;
        int endCol=n-1;
        while(sRow<=endRow && sCol<=endCol){
        //top
        for(int i=sCol;i<=endCol;i++){
            matrix[sRow][i]=num;
            num++;
        }
        //right
        for(int j=sRow+1;j<=endRow;j++){
            matrix[j][endCol]=num;
            num++;
        }
        //bottom
        for(int k=endCol-1;k>=sCol;k--){
            if(sRow==endRow){
                break;
            }
            matrix[endRow][k]=num;
            num++;
        }
        //left
        for(int f=endRow-1;f>=sRow+1;f--){
            if(sCol==endCol){
                break;
            }
            matrix[f][sCol]=num;
            num++;
        }
        sRow++;
        sCol++;
        endRow--;
        endCol--;
        }
        return matrix;

    }
}