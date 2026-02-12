<a href="https://www.geeksforgeeks.org/dsa/rat-in-a-maze/">Rat in a Maze</a>
Last Updated : 27 Sep, 2025
Given a square binary matrix mat[][] representing a maze. A rat starts at the top-left corner (0,0) and needs to reach the bottom-right corner (n-1, n-1). The rat can move in four directions: Up (U), Down (D), Left (L), Right (R).
Find all possible paths from (0, 0) to (n-1, n-1). If multiple paths exist, return them in lexicographically sorted order otherwise If no path exists, return empty list.

Note:

A rat cannot visit the same cell more than once in a path.
1 represents an open cell (rat can visit), and 0 represents a blocked cell (rat cannot visit).
Example:

Input: mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]