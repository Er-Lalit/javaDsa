<a href="https://www.geeksforgeeks.org/dsa/the-knights-tour-problem/">The Knight's Tour</a>
Last Updated : 29 Sep, 2025
Given an integer n, consider an n × n chessboard. A Knight starts at the top-left corner (0, 0) and must visit every cell exactly once following the Knight’s standard moves in chess (two steps in one direction and one step perpendicular).

Return the n × n grid where each cell contains the step number (starting from 0) at which the Knight visits that cell.
If no valid tour exists, return -1.
Examples:

Input: n = 5
Output:
[[0, 5, 14, 9, 20], 
[13, 8, 19, 4, 15],
[18, 1, 6, 21, 10],
[7, 12, 23, 16, 3],
[24, 17, 2, 11, 22]]