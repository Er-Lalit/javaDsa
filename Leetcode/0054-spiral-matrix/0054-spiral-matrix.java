class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
List<Integer> ll=new ArrayList();
int m=matrix.length;
int n=matrix[0].length;
int srow=0;
int scol=0;
int endrow=m-1;
int endcol=n-1; 
while(srow<=endrow && scol<=endcol){
    //top
    for(int j=scol;j<=endcol;j++){
        ll.add(matrix[srow][j]);
    }
    

    //right
    for(int i=srow+1;i<=endrow;i++){
        ll.add(matrix[i][endcol]);


    }
    

    //bottom
    for(int k=endcol-1;k>=scol;k--){
        if(srow==endrow){
            break;
        }
        ll.add(matrix[endrow][k]);
    }
    

    //left
    for(int f=endrow-1;f>=srow+1;f--){
        if(scol==endcol){
            break;
        }
        ll.add(matrix[f][scol]);
    }
    srow++;
    scol++;
    endcol--;
    endrow--;
}
return ll;  
    }
}