# What is Prim's Algorithm
Prim's (also known as Jarník's) algorithm is a greedy algorithm that finds a minimum spanning tree for a weighted undirected graph. This means it finds a subset of the edges that forms a tree that includes every vertex, where the total weight of all the edges in the tree is minimized. The algorithm operates by building this tree one vertex at a time, from an arbitrary starting vertex, at each step adding the cheapest possible connection from the tree to another vertex.

The algorithm was developed in 1930 by Czech mathematician Vojtěch Jarník and later rediscovered and republished by computer scientists Robert C. Prim in 1957 and Edsger W. Dijkstra in 1959.Therefore, it is also sometimes called the Jarník's algorithm, Prim–Jarník algorithm, Prim–Dijkstra algorithm or the DJP algorithm.

Other well-known algorithms for this problem include Kruskal's algorithm and Borůvka's algorithm. These algorithms find the minimum spanning forest in a possibly disconnected graph; in contrast, the most basic form of Prim's algorithm only finds minimum spanning trees in connected graphs. However, running Prim's algorithm separately for each connected component of the graph, it can also be used to find the minimum spanning forest. In terms of their asymptotic time complexity, these three algorithms are equally fast for sparse graphs, but slower than other more sophisticated algorithms. However, for graphs that are sufficiently dense, Prim's algorithm can be made to run in linear time, meeting or improving the time bounds for other algorithms.

### Algorithm
The algorithm may informally be described as performing the following steps:
* Initialize a tree with a single vertex, chosen arbitrarily from the graph.
* Grow the tree by one edge: of the edges that connect the tree to vertices not yet in the tree, find the minimum-weight edge, and transfer it to the tree.
* Repeat step 2 (until all vertices are in the tree).

In more detail, it may be implemented following the pseudocode below.

1. Associate with each vertex v of the graph a number C[v] (the cheapest cost of a connection to v) and an edge E[v] (the edge providing that cheapest connection). To initialize these values, set all values of C[v] to +∞ (or to any number larger than the maximum edge weight) and set each E[v] to a special flag value indicating that there is no edge connecting v to earlier vertices.
2. Initialize an empty forest F and a set Q of vertices that have not yet been included in F (initially, all vertices).
3. Repeat the following steps until Q is empty:
    * Find and remove a vertex v from Q having the minimum possible value of C[v]
    * Add v to F and, if E[v] is not the special flag value, also add E[v] to F
    * Loop over the edges vw connecting v to other vertices w. For each such edge, if w still belongs to Q and vw has smaller weight than C[w], perform the following steps:
        * Set C[w] to the cost of edge vw
        * Set E[w] to point to edge vw.
4. Return F

As described above, the starting vertex for the algorithm will be chosen arbitrarily, because the first iteration of the main loop of the algorithm will have a set of vertices in Q that all have equal weights, and the algorithm will automatically start a new tree in F when it completes a spanning tree of each connected component of the input graph. The algorithm may be modified to start with any particular vertex s by setting C[s] to be a number smaller than the other values of C (for instance, zero), and it may be modified to only find a single spanning tree rather than an entire spanning forest (matching more closely the informal description) by stopping whenever it encounters another vertex flagged as having no associated edge.

Different variations of the algorithm differ from each other in how the set Q is implemented: as a simple linked list or array of vertices, or as a more complicated priority queue data structure. This choice leads to differences in the time complexity of the algorithm. In general, a priority queue will be quicker at finding the vertex v with minimum cost, but will entail more expensive updates when the value of C[w] changes.

### Analysis
The time complexity of Prim's algorithm depends on the data structures used for the graph and for ordering the edges by weight, which can be done using a priority queue. The following table shows the typical choices:

| Minimum edge weight data structure | Time complexity (total)                                                                                                                                                                                                                                                                                                                                                                                 |
|------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| adjacency matrix, searching        | <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;O(\|V\|^{2})" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;O(\|V\|^{2})" title="O(\|V\|^{2})" /></a>                                                                                                                                                                                                  |
| binary heap and adjacency list     | <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;O((\|V\|&plus;\|E\|)\log&space;\|V\|)=O(\|E\|\log&space;\|V\|)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;O((\|V\|&plus;\|E\|)\log&space;\|V\|)=O(\|E\|\log&space;\|V\|)}" title="{\displaystyle O((\|V\|+\|E\|)\log \|V\|)=O(\|E\|\log \|V\|)}" /></a> |
| Fibonacci heap and adjacency list  | <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;O(\|E\|&plus;\|V\|\log&space;\|V\|)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;O(\|E\|&plus;\|V\|\log&space;\|V\|)}" title="{\displaystyle O(\|E\|+\|V\|\log \|V\|)}" /></a>                                                                            |

A simple implementation of Prim's, using an adjacency matrix or an adjacency list graph representation and linearly searching an array of weights to find the minimum weight edge to add, requires O(|V|2) running time. However, this running time can be greatly improved further by using heaps to implement finding minimum weight edges in the algorithm's inner loop.

A first improved version uses a heap to store all edges of the input graph, ordered by their weight. This leads to an O(|E| log |E|) worst-case running time. But storing vertices instead of edges can improve it still further. The heap should order the vertices by the smallest edge-weight that connects them to any vertex in the partially constructed minimum spanning tree (MST) (or infinity if no such edge exists). Every time a vertex v is chosen and added to the MST, a decrease-key operation is performed on all vertices w outside the partial MST such that v is connected to w, setting the key to the minimum of its previous value and the edge cost of (v,w).

Using a simple binary heap data structure, Prim's algorithm can now be shown to run in time O(|E| log |V|) where |E| is the number of edges and |V| is the number of vertices. Using a more sophisticated Fibonacci heap, this can be brought down to O(|E| + |V| log |V|), which is asymptotically faster when the graph is dense enough that |E| is ω(|V|), and linear time when |E| is at least |V| log |V|. For graphs of even greater density (having at least |V|c edges for some c > 1), Prim's algorithm can be made to run in linear time even more simply, by using a d-ary heap in place of a Fibonacci heap.

# What is Kruskal's Algorithm
Kruskal's algorithm finds a minimum spanning forest of an undirected edge-weighted graph. If the graph is connected, it finds a minimum spanning tree. (A minimum spanning tree of a connected graph is a subset of the edges that forms a tree that includes every vertex, where the sum of the weights of all the edges in the tree is minimized. For a disconnected graph, a minimum spanning forest is composed of a minimum spanning tree for each connected component.) It is a greedy algorithm in graph theory as in each step it adds the next lowest-weight edge that will not form a cycle to the minimum spanning forest.

This algorithm first appeared in Proceedings of the American Mathematical Society, pp. 48–50 in 1956, and was written by Joseph Kruskal.

Other algorithms for this problem include Prim's algorithm, the reverse-delete algorithm, and Borůvka's algorithm.

### Algorithm
Kruskal's Algorithm is given as:
* create a forest F (a set of trees), where each vertex in the graph is a separate tree
* create a set S containing all the edges in the graph
* while S is nonempty and F is not yet spanning
    * remove an edge with minimum weight from S
    * if the removed edge connects two different trees then add it to the forest F, combining two trees into a single tree

At the termination of the algorithm, the forest forms a minimum spanning forest of the graph. If the graph is connected, the forest has a single component and forms a minimum spanning tree

### Analysis
For a graph with E edges and V vertices, Kruskal's algorithm can be shown to run in O(E log E) time, or equivalently, O(E log V) time, all with simple data structures. These running times are equivalent because:

* E is at most <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;V^{2}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;V^{2}" title="V^{2}" /></a> and <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\log&space;V^{2}=2\log&space;V\in&space;O(\log&space;V)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\log&space;V^{2}=2\log&space;V\in&space;O(\log&space;V)}" title="{\displaystyle \log V^{2}=2\log V\in O(\log V)}" /></a>.
* Each isolated vertex is a separate component of the minimum spanning forest. If we ignore isolated vertices we obtain V ≤ 2E, so log V is <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;O(\log&space;E)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;O(\log&space;E)}" title="{\displaystyle O(\log E)}" /></a>.
We can achieve this bound as follows: first sort the edges by weight using a comparison sort in O(E log E) time; this allows the step "remove an edge with minimum weight from S" to operate in constant time. Next, we use a disjoint-set data structure to keep track of which vertices are in which components. We place each vertex into its own disjoint set, which takes O(V) operations. Finally, in worst case, we need to iterate through all edges, and for each edge we need to do two 'find' operations and possibly one union. Even a simple disjoint-set data structure such as disjoint-set forests with union by rank can perform O(E) operations in O(E log V) time. Thus the total time is O(E log E) = O(E log V).

Provided that the edges are either already sorted or can be sorted in linear time (for example with counting sort or radix sort), the algorithm can use a more sophisticated disjoint-set data structure to run in O(E α(V)) time, where α is the extremely slowly growing inverse of the single-valued Ackermann function.