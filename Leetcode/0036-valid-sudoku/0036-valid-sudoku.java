class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {
                    int num=board[i][j]-'0';
                    board[i][j]='.';

                    if(!isValid(board,i,j,num))
                    {
                       return false;
                    }
                    board[i][j]=(char)('0'-num);

                }
            }
        }
        return true;
        
    }
    static boolean isValid(char[][] board,int row,int col,int num)
    {
        //checking row 
        for(int i=0;i<9;i++)
        {
            if(board[row][i]==(char)('0'+num))
            {
                return false;
            }
        }
        //checking col
        for(int i=0;i<9;i++)
        {
            if(board[i][col]==(char)('0'+num))
            {
                return false;
            }
        }
        //now check in the 3*3 grid
        int sRow=row-row%3;
        int sCol=col-col%3;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[sRow+i][sCol+j]==(char)('0'+num))
                {
                    return false;
                }
            
            }
        }
        return true;

    }
}