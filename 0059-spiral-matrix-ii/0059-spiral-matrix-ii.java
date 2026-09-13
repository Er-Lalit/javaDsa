class Solution {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int rowS = 0;
        int colS = 0;
        int rowE = matrix.length - 1;
        int colE = matrix[0].length - 1;

        int num = 1;

        while (rowS <= rowE && colS <= colE) {

            // Top row
            int j = colS;
            while (j <= colE) {
                matrix[rowS][j] = num;
                num++;
                j++;
            }
            rowS++;

            // Right column
            int i = rowS;
            while (i <= rowE) {
                matrix[i][colE] = num;
                num++;
                i++;
            }
            colE--;

            // Bottom row
            if (rowS <= rowE) {

                int k = colE;
                while (k >= colS) {
                    matrix[rowE][k] = num;
                    num++;
                    k--;
                }

                rowE--;
            }

            // Left column
            if (colS <= colE) {

                int l = rowE;
                while (l >= rowS) {
                    matrix[l][colS] = num;
                    num++;
                    l--;
                }

                colS++;
            }
        }

        return matrix;
    }
}