class Solution {
    static int dir[][]={{-1,0},{1,0},{0,1},{0,-1},{-1,1},{-1,-1},{1,1},{1,-1}};
    public boolean isSafe(int grid[][],int x,int y)
    {
        int m=grid.length;
        int n=grid[0].length;
        return (x>=0 && y>=0 && x<m && y<n);
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(m==0 || n==0 || grid[0][0]!=0)
        {
            return -1;
        }

        //queue for bfs

        Queue<int[]> q=new ArrayDeque<>();

        q.offer(new int[]{0,0});
        int count=0;
        grid[0][0]=1;

        while(!q.isEmpty())
        {
            int size=q.size();

            while(size>0)
            {
                int arr[]=q.poll();
                int x=arr[0];
                int y=arr[1];

                if(x==m-1 && y==n-1)
                {
                    return count+1;
                }

                for(int d[]:dir)
                {
                    int x_=x+d[0];
                    int y_=y+d[1];
                    if(isSafe(grid,x_,y_)&& grid[x_][y_]==0)
                    {
                        q.offer(new int[]{x_,y_});
                        grid[x_][y_]=1;
                    }
                }
                size--;

            }
            count++;


        }
        return -1;
        
    }
}