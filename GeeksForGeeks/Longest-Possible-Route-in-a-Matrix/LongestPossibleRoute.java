public class LongestPossibleRoute {
    static int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) {
        int mat[][]=
        {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

        };
        int m=mat.length;
        int n=mat[0].length;
        int xs=0;
        int ys=0;
        int xd=1;
        int yd=7;
        int max=0;
        for(int i=xs;i<=xd;i++)
        {
            for(int j=ys;j<=yd;j++)
            {
                max=Math.max(max,solve(i, j, mat, m, n));                

            }
        }
        if(max==0)
        {
            System.out.println(-1);

        }
        else
        {
            System.out.println(max);
        }
        
    }
    static int solve(int i,int j,int mat[][],int m,int n)
    {
        if(i<0 || i>=m||j<0 || j>=n || mat[i][j]==0)
        {
            return 0;
        }
        int realVal=mat[i][j];
        mat[i][j]=0;
        int max=0;
        for(int arr[]:dir)
        {
            int newI=i+arr[0];
            int newJ=j+arr[1];
            max=Math.max(max,solve(newI,newJ, mat, m, n));


        }
        mat[i][j]=realVal;
        return max+realVal;

    }
    
}
