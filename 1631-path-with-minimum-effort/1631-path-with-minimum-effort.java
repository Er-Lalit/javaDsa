class Solution {
    static int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};

    // checking index out of bound 
    public boolean isSafe(int x,int y,int[][] heights)
    {
        int m=heights.length;
        int n=heights[0].length;
        return x>=0 && x<m && y>=0 && y<n ;

    }


    public int minimumEffortPath(int[][] heights) {

        int m=heights.length;
        int n=heights[0].length;
        int result[][]=new int[m][n];
        for(int i=0;i<result.length;i++)
        {
            Arrays.fill(result[i],Integer.MAX_VALUE);
        }
        result[0][0]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));

        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty())
        {
            int arr[]=pq.poll();

            int d=arr[0];
            int x=arr[1];
            int y=arr[2];
            for(int dir[]:direction)
            {
                int x_=x+dir[0];
                int y_=y+dir[1];

                if(isSafe(x_,y_,heights))
                {
                    int diff=Math.abs(heights[x][y]-heights[x_][y_]);

                    int maxDiff=Math.max(diff,d);

                    if(result[x_][y_]>maxDiff)
                    {
                        pq.offer(new int[]{maxDiff,x_,y_});
                        result[x_][y_]=maxDiff;
                    }

                    

                }
            }
        }

        return result[m-1][n-1];
        
    }
}