class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int direction[][]={{0,1},{1,0},{0,-1},{-1,0}};
        int ansMatrix[][]=new int[rows*cols][2];
        int index=0;
        ansMatrix[index][0]=rStart;
        ansMatrix[index][1]=cStart;
        index++;
        int step=0;
        int dir=0;
        while(index<rows*cols){
            if(dir==0 || dir==2){
                step++;
            }
            for(int count=0;count<step;count++){
                rStart+=direction[dir][0];
                cStart+=direction[dir][1];
                if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols){
                ansMatrix[index][0]=rStart;
                ansMatrix[index][1]=cStart;
                index++;
                }
            }
            dir=(dir+1)%4;
        }
return ansMatrix;

          
    }
}