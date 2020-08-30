# What is Quick Search
Quicksort (sometimes called partition-exchange sort) is an efficient sorting algorithm. Developed by British computer scientist Tony Hoare in 1959 and published in 1961, it is still a commonly used algorithm for sorting. When implemented well, it can be about two or three times faster than its main competitors, merge sort and heapsort.

Quicksort is a divide-and-conquer algorithm. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively. This can be done in-place, requiring small additional amounts of memory to perform the sorting.

Quicksort is a comparison sort, meaning that it can sort items of any type for which a "less-than" relation (formally, a total order) is defined. Efficient implementations of Quicksort are not a stable sort, meaning that the relative order of equal sort items is not preserved.

Mathematical analysis of quicksort shows that, on average, the algorithm takes <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;n\log&space;n&space;\right&space;)" title="O\left ( n\log n \right )" /> comparisons to sort n items. In the worst case, it makes <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;n^{2}&space;\right&space;)" title="O\left ( n^{2} \right )" /> comparisons, though this behavior is rare.

### Algorithm
Quicksort is a divide and conquer algorithm. It first divides the input array into two smaller sub-arrays: the low elements and the high elements. It then recursively sorts the sub-arrays. The steps for in-place Quicksort are:

* Pick an element, called a pivot, from the array.
* Partitioning: reorder the array so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it (equal values can go either way). After this partitioning, the pivot is in its final position. This is called the partition operation.
* Recursively apply the above steps to the sub-array of elements with smaller values and separately to the sub-array of elements with greater values.
* The base case of the recursion is arrays of size zero or one, which are in order by definition, so they never need to be sorted.

The pivot selection and partitioning steps can be done in several different ways; the choice of specific implementation schemes greatly affects the algorithm's performance.

### Analysis
##### Worst-case analysis
The most unbalanced partition occurs when one of the sublists returned by the partitioning routine is of size n − 1. This may occur if the pivot happens to be the smallest or largest element in the list, or in some implementations when all the elements are equal.

If this happens repeatedly in every partition, then each recursive call processes a list of size one less than the previous list. Consequently, we can make n − 1 nested calls before we reach a list of size 1. This means that the call tree is a linear chain of n − 1 nested calls. The ith call does <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;n-i&space;\right&space;)" title="O\left ( n-i \right )" /> work to do the partition, and 
<img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\textstyle&space;\sum&space;_{i=0}^{n}(n-i)\in&space;O(n^{2})}" title="{\displaystyle \textstyle \sum _{i=0}^{n}(n-i)\in O(n^{2})}" />, so in that case Quicksort takes <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;n^{2}&space;\right&space;)" title="O\left ( n^{2} \right )" /> time.

##### Best-case analysis
In the most balanced case, each time we perform a partition we divide the list into two nearly equal pieces. This means each recursive call processes a list of half the size. Consequently, we can make only <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;\lg&space;n" title="\lg n" /> nested calls before we reach a list of size 1. This means that the depth of the call tree is <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;\lg&space;n" title="\lg n" />. But no two calls at the same level of the call tree process the same part of the original list; thus, each level of calls needs only O(n) time all together (each call has some constant overhead, but since there are only <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;n&space;\right&space;)" title="O\left ( n \right )" /> calls at each level, this is subsumed in the <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;n&space;\right&space;)" title="O\left ( n \right )" /> factor). The result is that the algorithm uses only <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;n\log&space;n&space;\right&space;)" title="O\left ( n\log n \right )" /> time.

##### Average-case analysis
To sort an array of n distinct elements, quicksort takes <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;n\log&space;n&space;\right&space;)" title="O\left ( n\log n \right )" /> time in expectation, averaged over all n! permutations of n elements with equal probability.

### Space complexity
The space used by quicksort depends on the version used.

The in-place version of quicksort has a space complexity of <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;\log&space;n&space;\right&space;)" title="O\left ( \log n \right )" />, even in the worst case, when it is carefully implemented using the following strategies:

* in-place partitioning is used. This unstable partition requires O(1) space.
* After partitioning, the partition with the fewest elements is (recursively) sorted first, requiring at most O(log n) space. Then the other partition is sorted using tail recursion or iteration, which doesn't add to the call stack. This idea, as discussed above, was described by R. Sedgewick, and keeps the stack depth bounded by <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;\log&space;n&space;\right&space;)" title="O\left ( \log n \right )" />.
Quicksort with in-place and unstable partitioning uses only constant additional space before making any recursive call. Quicksort must store a constant amount of information for each nested recursive call. Since the best case makes at most O(log n) nested recursive calls, it uses <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;\log&space;n&space;\right&space;)" title="O\left ( \log n \right )" /> space. However, without Sedgewick's trick to limit the recursive calls, in the worst case quicksort could make <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;n&space;\right&space;)" title="O\left ( n \right )" /> nested recursive calls and need <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;n&space;\right&space;)" title="O\left ( n \right )" /> auxiliary space.

From a bit complexity viewpoint, variables such as lo and hi do not use constant space; it takes <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;\log&space;n&space;\right&space;)" title="O\left ( \log n \right )" /> bits to index into a list of n items. Because there are such variables in every stack frame, quicksort using Sedgewick's trick requires <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;\left&space;(&space;\log&space;n&space;\right&space;)^{2}&space;\right&space;)" title="O\left ( \left ( \log n \right )^{2} \right )" /> bits of space. This space requirement isn't too terrible, though, since if the list contained distinct elements, it would need at least <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;n\log&space;n&space;\right&space;)" title="O\left ( n\log n \right )" /> bits of space.

Another, less common, not-in-place, version of quicksort uses <img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O\left&space;(&space;n&space;\right&space;)" title="O\left ( n \right )" /> space for working storage and can implement a stable sort. The working storage allows the input array to be easily partitioned in a stable manner and then copied back to the input array for successive recursive calls. Sedgewick's optimization is still appropriate.