class Solution {
    public void solveSudoku(char[][] board) {
        solve(0,0,board);
        
    }

    static boolean solve(int r,int c,char[][] board)
    {      
        if(r==board.length)
        {
            return true;
        }
        if(c==board[0].length)
        {
            return solve(r+1,0,board);
        }
        if(board[r][c]!='.')
        {
            return solve(r,c+1,board);
        }
        //now we are trying to put number from 0 to 9 here 
        for(int i=1;i<=9;i++)
        {
            if(isTrue(board,r,c,i))
            {
                board[r][c]=(char)('0'+i);

                if(solve(r,c+1,board))
                {
                    return true;
                }
                board[r][c]='.';
            }
        }
        return false;

    }      






    static boolean isTrue(char board[][],int row,int col,int num)
    {
        // check the horizontally
        for(int i=0;i<9;i++)
        {
            if(board[row][i]==(char)('0'+num))
            {
                return false;
            }
        }
        //check vertically bellow
        for(int i=0;i<9;i++)
        {
            if(board[i][col]==(char)('0'+num))
            {
                return false;
            }
        }
        //now check in subboxes
        int square=(int)Math.sqrt(board.length);
        int checkRow=row-row%square;
        int checkCol=col-col%square;
        for(int i=0;i<square;i++)
        {
            for(int j=0;j<square;j++)
            {
                if(board[checkRow+i][checkCol+j]==(char)('0'+num))
                {
                    return false;
                }
            }
        }
        return true;
    }
}