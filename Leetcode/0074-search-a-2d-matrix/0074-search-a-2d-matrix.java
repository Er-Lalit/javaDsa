class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        if(row==1){
            return binarySearch(matrix,0,col-1,0,target);
        }
        int rStart=0;
        int rEnd=row-1;
        int cMid=(0+col-1)/2;
        while(rStart<(rEnd-1)){
          int   rMid=(rStart+rEnd)/2;
            if(matrix[rMid][cMid]==target){
                return true;
            }
          else  if(target< matrix[rMid][cMid]){
            rEnd=rMid;

            }
            else{
                rStart=rMid;
            }
         

        }
          // now we have a two row check weather the element in the midel column of the row 
           
         if(matrix[rStart][cMid]==target){
                return true;

            }
            if(matrix[rEnd][cMid]==target){
                return true;
            }
         // now search is for reaming half 
         if(cMid-1>=0 && target<=matrix[rStart][cMid-1]){
            return  binarySearch(matrix,rStart,cMid-1,0,target);
         }
         if(cMid+1<col && target>=matrix[rStart][cMid+1] && target<=matrix[rStart][col-1]){
            return binarySearch(matrix,rStart,col-1,cMid+1,target);
         }
         if(cMid-1>=0 && target<=matrix[rStart+1][cMid-1]){
             return  binarySearch(matrix,rStart+1,cMid-1,0,target);

         }else{
            return  binarySearch(matrix,rStart+1,col-1,cMid+1,target);
         }
        
    }
    static boolean binarySearch(int matrix[][],int rStart,int cEnd,int cStart,int target){
        while(cStart<=cEnd){
            int mid=(cStart+cEnd)/2;
            if(target==matrix[rStart][mid]){
                return true;
            }
            else if(target<matrix[rStart][mid]){
                cEnd=mid-1;
            }
            else{
                cStart=mid+1;
            }
        }
        return false;
    }
}