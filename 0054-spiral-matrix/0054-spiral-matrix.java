class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int rowS=0;
        int colS=0;
        int rowE=matrix.length-1;
        int colE=matrix[0].length-1;

        while(rowS<=rowE && colS<=colE)
        {
            int j=colS;
            while(j<=colE)
            {
                ans.add(matrix[rowS][j]);
                j++;
            }
            rowS++;

            int i=rowS;
            while(i<=rowE)
            {
                ans.add(matrix[i][colE]);
                i++;
            }
            colE--;

            if(rowS<=rowE)
            {

            

            int k=colE;
            while(k>=colS)
            {
                ans.add(matrix[rowE][k]);
                k--;
            }

            rowE--;

            }

            if(colS<=colE)
            {
        int l=rowE;
        while(l>=rowS)
        {
            ans.add(matrix[l][colS]);
            l--;
        }
        colS++;  

            }          
        }

        return ans;


        
    }
    
}