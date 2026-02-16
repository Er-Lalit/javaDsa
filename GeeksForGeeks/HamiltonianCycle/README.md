<a href="https://www.geeksforgeeks.org/dsa/hamiltonian-cycle/">Hamiltonian Cycle</a>
Last Updated : 31 Jan, 2026
A Hamiltonian Cycle or Circuit in a graph G is a cycle that visits each vertex of G exactly once and returns to the starting vertex.

If a graph has a Hamiltonian cycle, it's a Hamiltonian graph; otherwise, it's non-Hamiltonian.
Finding a Hamiltonian cycle is an NP-complete problem, meaning there's no known efficient solution for all graph types, but solutions exist for smaller or specific types.
The Hamiltonian Cycle problem has applications in logistics, network design, and computer science.
Sample Problem
Given an undirected graph, the task is to determine if it contains a Hamiltonian cycle. If found, print the path; otherwise, print "Solution does not exist".

Examples:

Input: N=5, adjMat[][] = [[0, 1, 0, 1, 0], [1, 0, 1, 1, 1], [0, 1, 0, 0, 1], [1, 1, 0, 0, 1], [0, 1, 1, 1, 0]]