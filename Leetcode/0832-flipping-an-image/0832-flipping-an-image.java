class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] arr=new int[image.length][image[0].length];
        for(int i=0;i<image.length;i++){
            int k=0;
            for(int j=image[0].length-1;j>=0;j--){
                if(image[i][j]==1){
                    arr[i][k]=0;
                    k++;
                }
                else{
                    arr[i][k]=1;
                    k++;
                }
            }
        }   
        return arr;   
    }
}