class Solution {
    public List<List<String>> solveNQueens(int n) {

        String board[][]=new String[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]=".";
            }
        }
        List<List<String>> ans=new ArrayList<>();
        nQueens(ans,0,n,board);
        return ans;
        
    }
    static void  nQueens(List<List<String>> ans,int row,int n,String board[][])
    {
        if(row==n)
        {
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    sb.append(board[i][j]);
                }
                temp.add(sb.toString());
            }
            ans.add(temp);

            return;
        }
        for(int col=0;col<n;col++)
        {
           if(isTrue(row, col, board))
           {
               board[row][col]="Q";
               nQueens(ans,row+1,n,board);
               board[row][col]=".";

            }
        }

    }
    static boolean isTrue(int row,int col,String board[][])
    {
        //checking if above we have a queens 
        for(int curr=row;curr>=0;curr--)
        {
            if(board[curr][col].equals("Q"))
            {
                return false;
            }
        }
        //checking left diagonal
        int maxLeft=Math.min(row,col);
        
        for(int i=1;i<=maxLeft;i++)
        {
            if(board[row-i][col-i].equals("Q"))
            {
                return false;

            }
        }
        //checking right diagonal
        int maxRigth=Math.min(row,board.length-1-col);
        for(int i=1;i<=maxRigth;i++)
        {
            if(board[row-i][col+i].equals("Q"))
            {
                return false;
            }
        }
        return true;

    }
}