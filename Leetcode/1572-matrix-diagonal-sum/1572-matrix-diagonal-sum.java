class Solution {
    public int diagonalSum(int[][] mat) {
        int col=mat[0].length-1;
        int j=0;
        int lDSum=0;
        int rDSum=0;
        for(int i=0;i<mat.length;i++){
            lDSum+=mat[i][j++];
            if(j-1==col){
                col--;
                continue;
            }
            rDSum+=mat[i][col--];
        

        }
        return lDSum+rDSum;
        
    }
}