class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        List<Integer> minList=new ArrayList<>();
    List<Integer> maxList=new ArrayList<>();
    List<Integer> ansList=new ArrayList<>();
    for(int i=0;i<matrix.length;i++){
      int minElement=Integer.MAX_VALUE;
      for(int j=0;j<matrix[0].length;j++){
        minElement=Math.min(minElement,matrix[i][j]);
        

        // if(matrix[i][j]<minElement){
        //   minElement=matrix[i][j];
        // }
      }
      max=Math.max(minElement,max);
      minList.add(minElement);
    }
    for(int i=0;i<matrix[0].length;i++){
      int maxElement=0;
      for(int j=0;j<matrix.length;j++){
        maxElement=Math.max(matrix[j][i],maxElement);
       

        // if(matrix[j][i]>maxElement){
        //   maxElement=matrix[j][i];
        // }
      }
       min=Math.min(min,maxElement);
      maxList.add(maxElement);
    }
    // for(int i=0;i<matrix.length;i++){
    //   for(int j=0;j<matrix[0].length;j++){
    //     if(matrix[i][j]==minList.get(i) && matrix[i][j]==maxList.get(j) ){
    //         ansList.add(matrix[i][j]);
    //         return ansList;
         

    //     }
    //   }
    // }
    if(min==max){
        ansList.add(max);
        return ansList;
    }
    
        return ansList;
    }
}