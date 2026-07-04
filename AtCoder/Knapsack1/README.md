<a href="https://atcoder.jp/contests/dp/tasks/dp_d"> D - Knapsack 1</a>

## Problem Statement

There are **N** items, numbered **1, 2, ..., N**. For each item **i** (`1 ≤ i ≤ N`):

* **Weight:** `wi`
* **Value:** `vi`

Taro wants to choose some of these items and carry them home in a knapsack.

The knapsack has a maximum capacity of **W**, meaning that the total weight of the selected items must not exceed **W**.

Your task is to determine the **maximum possible total value** of the selected items while satisfying the weight constraint.

---

## Input Format

```text
N W
w1 v1
w2 v2
...
wN vN
```

* `N` — Number of items
* `W` — Capacity of the knapsack
* `wi` — Weight of the `i`-th item
* `vi` — Value of the `i`-th item

---

## Output Format

Print a single integer representing the maximum possible total value that can be obtained without exceeding the knapsack's capacity.

---

## Constraints

* `1 ≤ N ≤ 100`
* `1 ≤ W ≤ 10^5`
* `1 ≤ wi ≤ W`
* `1 ≤ vi ≤ 10^9`

**Note:** The answer may not fit into a 32-bit integer type.

---

## Sample Input 1

```text
3 8
3 30
4 50
5 60
```

## Sample Output 1

```text
90
```

---

## Sample Input 2

```text
5 5
1 1000000000
1 1000000000
1 1000000000
1 1000000000
1 1000000000
```

## Sample Output 2

```text
5000000000
```

---

## Sample Input 3

```text
6 15
6 5
5 6
6 4
6 6
3 5
7 2
```

## Sample Output 3

```text
17
```
