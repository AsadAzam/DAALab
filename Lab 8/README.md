# What is N-Queen Problem
The N queens puzzle is the problem of placing N chess queens on an NxN chessboard so that no two queens threaten each other; thus, a solution requires that no two queens share the same row, column, or diagonal. The eight queens puzzle is an example of the more general n queens problem of placing n non-attacking queens on an n×n chessboard, for which solutions exist for all natural numbers n with the exception of n = 2 and n = 3.

### Algorithm
The idea is to place queens one by one in different columns, starting from the leftmost column. When we place a queen in a column, we check for clashes with already placed queens. In the current column, if we find a row for which there is no clash, we mark this row and column as part of the solution. If we do not find such a row due to clashes then we backtrack and return false.

1) Start in the leftmost column
2) If all queens are placed
    return true
3) Try all rows in the current column. 
   Do following for every tried row.
    * If the queen can be placed safely in this row 
       then mark this [row, column] as part of the 
       solution and recursively check if placing
       queen here leads to a solution.
    * If placing the queen in [row, column] leads to
       a solution then return true.
    * If placing queen doesn't lead to a solution then
       unmark this [row, column] (Backtrack) and go to 
       step (a) to try other rows.
3) If all rows have been tried and nothing worked,
   return false to trigger backtracking.

### Analysis
The algorithm uses an auxiliary array of length N to store just N positions. The isSafe method takes O(N) time as it iterates through our array every time. For each invocation of the placeQueen method, there is a loop which runs for O(N) time.

# What is Optimal Merge Problem
Optimal merge pattern is a pattern that relates to the merging of two or more sorted files in a single sorted file. This type of merging can be done by the two-way merging method.

If we have two sorted files containing n and m records respectively then they could be merged together, to obtain one sorted file in time O(n+m).

There are many ways in which pairwise merge can be done to get a single sorted file. Different pairings require a different amount of computing time.The main thing is to pairwise merge the n sorted files so that the number of comparisons will be less.

### Algorithm
A simpel approack towards Optimal Merge Pattern: 
1. Add all the nodes in a priority queue (Min Heap).{node.weight = file size}
2. Initialize count = 0 // variable to store file computations.
3. Repeat while (size of priority Queue is greater than 1)
    * create a new node
    * new node = pq.poll().weight+pq.poll().weight; (pq) denotes priority queue, remove 1st smallest and 2nd smallest element and add their weights to get a new node
    * count += node.wight
    * add this new node to priority queue;
4. count is the final answer

### Analysis
The main for loop in this algorithm is executed in n-1 times. If the list is kept in increasing order according to the weight value in the roots, then least (list) needs only O(1) time and insert (list, t) can be performed in O(n) time. Hence, the total time taken is O (n2). If the list is represented as a minheap in which the root value is less than or equal to the values of its children, then least (list) and insert (list, t) can be done in O (log n) time. In this condition, the computing time for the tree is O (n log n).