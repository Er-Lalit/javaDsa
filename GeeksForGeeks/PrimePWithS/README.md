Prime numbers after prime P with sum S
Last Updated : 23 Jan, 2023
Given three numbers sum S, prime P, and N, find all N prime numbers after prime P such that their sum is equal to S.
Examples : 
 

Input :  N = 2, P = 7, S = 28 
Output : 11 17
Explanation : 11 and 17 are primes after
prime 7 and (11 + 17 = 28) 

Input :  N = 3, P = 2, S = 23 
Output : 3 7 13
         5 7 11
Explanation : 3, 5, 7, 11 and 13 are primes 
after prime 2. And (3 + 7 + 13 = 5 + 7 + 11 
= 23) 

Input :  N = 4, P = 3, S = 54
Output : 5 7 11 31 
         5 7 13 29 
         5 7 19 23 
         5 13 17 19 
         7 11 13 23 
         7 11 17 19 
Explanation : All are prime numbers and 
their sum is 54