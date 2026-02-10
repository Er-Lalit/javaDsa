class Solution {
    public int totalNQueens(int n) {
        String board[][]=new String[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]=".";
            }
        }
        return nQueens(board,0,n);
        
    }
    static int nQueens(String board[][],int row,int n)
    {
        int count=0;

        for(int col=0;col<n;col++)
        {
            if(row==n)
            {
                return 1;
            }

            
            if(isTrue(row,col,board))
            {
                board[row][col]="Q";
                count+=nQueens(board,row+1,n);
                board[row][col]="";
            }

        }
        return count;

    }
    static boolean isTrue(int row, int col, String board[][])
    {
        //if vertical above 
        for(int curr=row;curr>=0;curr--)
        {
          if(  board[curr][col].equals("Q"))
          {
            return false;
          }
        }
        //check the left diogonal
        int maxLeft=Math.min(row,col);
        for(int i=1;i<=maxLeft;i++)
        {
            if(board[row-i][col-i].equals("Q"))
            {
                return false;
            }
        }
        //check the right diagonal
        int maxRight=Math.min(row,board.length-1-col);
        for(int i=1;i<=maxRight;i++)
        {
            if(board[row-i][col+i].equals("Q"))
            {
                return false;
            }
        }
        return true;

    }

}