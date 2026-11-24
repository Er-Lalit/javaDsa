// ** aaproach 1 bfs
// class Solution {
//     static int dir[][]={{-1,0},{1,0},{0,1},{0,-1},{-1,1},{-1,-1},{1,1},{1,-1}};
//     public boolean isSafe(int grid[][],int x,int y)
//     {
//         int m=grid.length;
//         int n=grid[0].length;
//         return (x>=0 && y>=0 && x<m && y<n);
//     }
//     public int shortestPathBinaryMatrix(int[][] grid) {
//         int m=grid.length;
//         int n=grid[0].length;
//         if(m==0 || n==0 || grid[0][0]!=0)
//         {
//             return -1;
//         }

//         //queue for bfs

//         Queue<int[]> q=new ArrayDeque<>();

//         q.offer(new int[]{0,0});
//         int count=0;
//         grid[0][0]=1;

//         while(!q.isEmpty())
//         {
//             int size=q.size();

//             while(size>0)
//             {
//                 int arr[]=q.poll();
//                 int x=arr[0];
//                 int y=arr[1];

//                 if(x==m-1 && y==n-1)
//                 {
//                     return count+1;
//                 }

//                 for(int d[]:dir)
//                 {
//                     int x_=x+d[0];
//                     int y_=y+d[1];
//                     if(isSafe(grid,x_,y_)&& grid[x_][y_]==0)
//                     {
//                         q.offer(new int[]{x_,y_});
//                         grid[x_][y_]=1;
//                     }
//                 }
//                 size--;

//             }
//             count++;


//         }
//         return -1;
        
//     }
//}

// ** approach 2 dijkstra

class Solution{

    static int dir[][]={{-1,0},{1,0},{0,1},{0,-1},{-1,1},{-1,-1},{1,1},{1,-1}};
    public boolean isSafe(int grid[][],int x,int y)
    {
        int m=grid.length;
        int n=grid[0].length;
        return (x>=0 && y>=0 && x<m && y<n);
    }
    
    public int shortestPathBinaryMatrix(int[][] grid)
    {
        if(grid.length==0 || grid[0].length==0 || grid[0][0]==1)
        {
            return -1;
        }

        int distance[][] = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        distance[0][0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
    (a, b) -> Integer.compare(a[0], b[0])
);
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty())
        {
            int arr[]=pq.poll();
            int w=arr[0];
            int x=arr[1];
            int y=arr[2];
            for(int d[]:dir)
            {
                int x_=x+d[0];
                int y_=y+d[1];

                if(isSafe(grid,x_,y_) && grid[x_][y_]==0 && w+1<distance[x_][y_])
                {
                    pq.offer(new int[]{w+1,x_,y_});
                    grid[x_][y_]=1;
                    distance[x_][y_]=w+1;
                    
                }

            }
        }
        if(distance[grid.length-1][grid[0].length-1]==Integer.MAX_VALUE)
        {
            return -1;
        }
        return distance[grid.length-1][grid[0].length-1]+1;
    }
}