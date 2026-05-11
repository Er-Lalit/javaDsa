<p><a href="https://atcoder.jp/contests/abc185/tasks/abc185_f"> Range Xor Query </a></p>
Time Limit: 3 sec / Memory Limit: 1024 MiB

Score : 
600 points

Problem Statement
We have an integer sequence 
A of length 
N.
You will process 
Q queries on this sequence. In the 
i-th query, given values 
T 
i
​
 , 
X 
i
​
 , and 
Y 
i
​
 , do the following:

If 
T 
i
​
 =1, replace 
A 
X 
i
​
 
​
  with 
A 
X 
i
​
 
​
 ⊕Y 
i
​
 .
If 
T 
i
​
 =2, print 
A 
X 
i
​
 
​
 ⊕A 
X 
i
​
 +1
​
 ⊕A 
X 
i
​
 +2
​
 ⊕⋯⊕A 
Y 
i
​
 
​
 .
Here, 
a⊕b denotes the bitwise XOR of 
a and 
b.

What is bitwise XOR?
Constraints
1≤N≤300000
1≤Q≤300000
0≤A 
i
​
 <2 
30
 
T 
i
​
  is 
1 or 
2.
If 
T 
i
​
 =1, then 
1≤X 
i
​
 ≤N and 
0≤Y 
i
​
 <2 
30
 .
If 
T 
i
​
 =2, then 
1≤X 
i
​
 ≤Y 
i
​
 ≤N.
All values in input are integers.
Input
Input is given from Standard Input in the following format:

N 
Q
A 
1
​
 A 
2
​
 A 
3
​
 …A 
N
​
 
T 
1
​
  
X 
1
​
  
Y 
1
​
 
T 
2
​
  
X 
2
​
  
Y 
2
​
 
T 
3
​
  
X 
3
​
  
Y 
3
​
 
⋮
T 
Q
​
  
X 
Q
​
  
Y 
Q
​
 
Output
For each query with 
T 
i
​
 =2 in the order received, print the response in its own line.

Sample Input 1

3 4
1 2 3
2 1 3
2 2 3
1 2 3
2 2 3
Sample Output 1
0
1
2
In the first query, we print 
1⊕2⊕3=0.
In the second query, we print 
2⊕3=1.
In the third query, we replace 
A 
2
​
  with 
2⊕3=1.
In the fourth query, we print 
1⊕3=2.

Sample Input 2

10 10
0 5 3 4 7 0 0 0 1 0
1 10 7
2 8 9
2 3 6
2 1 6
2 1 10
1 9 4
1 6 1
1 6 3
1 1 7
2 3 5
Sample Output 2

1
0
5
3
0