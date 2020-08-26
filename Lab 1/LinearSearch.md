# What is Linear Search
A linear search or sequential search is a method for finding an element within a list. It sequentially checks each element of the list until a match is found or the whole list has been searched.

### Algorithm
Given a list L of n elements with values or records L0 .... Ln−1, and target value T, the following subroutine uses linear search to find the index of the target T in L.
* Set i to 0.
* If Li = T, the search terminates successfully; return i.
* Increase i by 1.
* If i < n, go to step 2. Otherwise, the search terminates unsuccessfully.

### Analysis
For a list with n items, the best case is when the value is equal to the first element of the list, in which case only one comparison is needed. The worst case is when the value is not in the list (or occurs only once at the end of the list), in which case n comparisons are needed.

If the value being sought occurs k times in the list, and all orderings of the list are equally likely, the expected number of comparisons is

<img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\begin{cases}n&{\mbox{if&space;}}k=0\\[5pt]\displaystyle&space;{\frac&space;{n&plus;1}{k&plus;1}}&{\mbox{if&space;}}1\leq&space;k\leq&space;n.\end{cases}}" title="{\begin{cases}n&{\mbox{if }}k=0\\[5pt]\displaystyle {\frac {n+1}{k+1}}&{\mbox{if }}1\leq k\leq n.\end{cases}}" />

For example, if the value being sought occurs once in the list, and all orderings of the list are equally likely, the expected number of comparisons is (n + 1)/2. However, if it is known that it occurs once, then at most n - 1 comparisons are needed, and the expected number of comparisons is

<img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;\frac{(n&plus;2)(n-1)}{2n}" title="\frac{(n+2)(n-1)}{2n}" />

(for example, for n = 2 this is 1, corresponding to a single if-then-else construct).
Either way, asymptotically the worst-case cost and the expected cost of linear search are both O(n).