Longest Possible Route in a Matrix
Last Updated : 17 Nov, 2025
Given a 2D binary matrix mat[][] where 0 represent hurdle and 1 free cell. Find the length of the longest path from a source (xs, ys) to a destination (xd, yd) with these rules:

Move only up, down, left, or right (no diagonals).
Each cell can be visited at most once in a path.
If reaching the destination is impossible, return -1.
Examples:

Input: xs = 0, ys = 0, xd = 1, yd = 7
mat[][] = [ [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
                   [1, 1, 0, 1, 1, 0, 1, 1, 0, 1],
                   [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]]
Output: 24
Explanation:

420046962
 
Input:  xs = 0, ys = 3, xd = 2, yd = 2
mat[][] =[ [1, 0, 0, 1, 0],
                  [0, 0, 0, 1, 0],
                 [0, 1, 1, 0, 0]]
Output: -1