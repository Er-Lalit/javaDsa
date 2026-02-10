class Solution {
    public void setZeroes(int[][] matrix) {
        // if(matrix.length==1 && matrix[0].length==1){
        //     return ;
        // }
        List<List<Integer>> ll=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    ll.add(List.of(i,j));
                }
            }
        }
        // System.out.println(ll);
        // System.out.println(ll.size());
        
        int rStart=0;
        int cStart=0;
        int rEnd=matrix.length-1;
        int cEnd=matrix[0].length-1;
        int index=0;
        while(index<=ll.size()){
            if(ll.isEmpty()){return ;}
             int crStart=0;
            int ccStart=0;
            for(List s:ll){
                crStart=(int)s.get(0);
                ccStart=(int)s.get(1);
                
                index++;
           
        //top
        for( int i=crStart-1;i>=rStart;i--){
            matrix[i][ccStart]=0;
        }
        //right
        for(int j=ccStart+1;j<=cEnd;j++){
            matrix[crStart][j]=0;

        }
        //bottom
        for(int k=crStart+1;k<=rEnd;k++){
            matrix[k][ccStart]=0;
        }
        // left
        for(int f=ccStart-1;f>=cStart;f--){
            matrix[crStart][f]=0;
        }
         }
    }
        
    }
}