class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rStart=0;
        int rEnd=mat.length-1;
        int cStart=0;
        int cEnd=mat[0].length-1;
        while(cStart<=cEnd){
            int mid=(cStart+cEnd)/2;
            int row=max(rStart,rEnd,mid,mat);
            int left=mid-1>=0?mat[row][mid-1]:-1;
            int right=mid+1<=cEnd?mat[row][mid+1]:-1;
            if(mat[row][mid]>left && mat[row][mid]>right){
                return new int[]{row,mid};
            }
            else if(mat[row][mid]<right){
                cStart=mid+1;
            }
            else{
                cEnd=mid-1;
            }


            
        }
        return new int[]{-1,-1};
        
    }
    static int max(int rStart, int rEnd,int mid,int mat[][]){
        int maximum=Integer.MIN_VALUE;
        int row=-1;
        for(int i=rStart;i<=rEnd;i++){
            if(mat[i][mid]>maximum){
                maximum=mat[i][mid];
                row=i;
            }

        }
        return row;
    }
}