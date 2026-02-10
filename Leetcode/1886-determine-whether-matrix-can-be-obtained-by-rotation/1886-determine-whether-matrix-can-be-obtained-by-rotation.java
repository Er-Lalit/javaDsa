class Solution {
     static boolean isMatch(int arr[][],int mat[][]){
      for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++){
          if(arr[i][j]!=mat[i][j]){
            return false;
          }
        }
      }
      return true;
    
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length-1;
      int count=0;
      while(count<4){
       int arr[][]=new int[mat.length][mat.length];

    
      
      for(int i=0;i<mat.length;i++){
        for(int j=0;j<mat[0].length;j++){
          arr[j][n-i]=mat[i][j];

        }
      }
     
      if( isMatch(arr, target)){
       
        return true;
      }
      
      
      count++;
      mat=arr;
       
    }
    return false;
   
    }
}