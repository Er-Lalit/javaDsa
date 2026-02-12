Equal Partition
Last Updated : 30 Sep, 2025
Given an integer array arr[], divide it into two subsets such that the absolute difference between their sums is zero (i.e., both subsets have the same sum).

If the size of the array is even, each subset must contain exactly n/2 elements.
If the size of the array is odd, then one subset must contain n/2 elements and the other must contain (n+1)/2 elements.
Note: It is always guaranteed that the array can be divided into two such subsets.

Examples:

Input: arr[] = [1, 2, 3, 4]
Output: [[1, 4], [2, 3]]
Explanation: The absolute difference between the sum of both subsets is 0

Input: arr[] = [5, 10, 15]
Output: [[5, 10], [15]]