# What is Floyd–Warshall Algorithm
Floyd–Warshall algorithm (also known as Floyd's algorithm, the Roy–Warshall algorithm, the Roy–Floyd algorithm, or the WFI algorithm) is an algorithm for finding shortest paths in a weighted graph with positive or negative edge weights (but with no negative cycles). A single execution of the algorithm will find the lengths (summed weights) of shortest paths between all pairs of vertices. Although it does not return details of the paths themselves, it is possible to reconstruct the paths with simple modifications to the algorithm. Versions of the algorithm can also be used for finding the transitive closure of a relation <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;R" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;R" title="R" /></a>, or (in connection with the Schulze voting system) widest paths between all pairs of vertices in a weighted graph.

### Algorithm
The Floyd–Warshall algorithm compares all possible paths through the graph between each pair of vertices. It is able to do this with <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;\Theta&space;(|V|^{3})" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;\Theta&space;(|V|^{3})" title="\Theta (|V|^{3})" /></a> comparisons in a graph, even though there may be up to <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\Omega&space;(|V|^{2})}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\Omega&space;(|V|^{2})}" title="{\displaystyle \Omega (|V|^{2})}" /></a> edges in the graph, and every combination of edges is tested. It does so by incrementally improving an estimate on the shortest path between two vertices, until the estimate is optimal.

Consider a graph <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;G" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;G" title="G" /></a> with vertices <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;V" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;V" title="V" /></a> numbered 1 through <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;N" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;N" title="N" /></a>. Further consider a function <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k)}" title="{\displaystyle \mathrm {shortestPath} (i,j,k)}" /></a> that returns the shortest possible path from <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;i" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;i" title="i" /></a> to <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;j" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;j" title="j" /></a> using vertices only from the set <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\{1,2,\ldots&space;,k\}}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\{1,2,\ldots&space;,k\}}" title="{\displaystyle \{1,2,\ldots ,k\}}" /></a> as intermediate points along the way. Now, given this function, our goal is to find the shortest path from each <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;i" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;i" title="i" /></a> to each <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;j" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;j" title="j" /></a> using any vertex in <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;\{1,2,\ldots&space;,N\}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;\{1,2,\ldots&space;,N\}" title="\{1,2,\ldots ,N\}" /></a>.

For each of these pairs of vertices, the <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k)}" title="{\displaystyle \mathrm {shortestPath} (i,j,k)}" /></a> could be either

1.  a path that does not go through 
<a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;k" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;k" title="k" /></a> (only uses vertices in the set <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\{1,\ldots&space;,k-1\}}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\{1,\ldots&space;,k-1\}}" title="{\displaystyle \{1,\ldots ,k-1\}}" /></a>.)

or

2.  a path that does go through <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;k" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;k" title="k" /></a> (from <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;i" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;i" title="i" /></a> to <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;k" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;k" title="k" /></a> and then from <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;k" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;k" title="k" /></a> to <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;j" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;j" title="j" /></a>, both only using intermediate vertices in 
<a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\{1,\ldots&space;,k-1\}}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\{1,\ldots&space;,k-1\}}" title="{\displaystyle \{1,\ldots ,k-1\}}" /></a>)

We know that the best path from <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;i" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;i" title="i" /></a> to <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;i" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;j" title="j" /></a> that only uses vertices <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;1" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;1" title="1" /></a> through <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;k-1" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;k-1" title="k-1" /></a> is defined by <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k-1)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k-1)}" title="{\displaystyle \mathrm {shortestPath} (i,j,k-1)}" /></a>, and it is clear that if there was a better path from <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;i" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;i" title="i" /></a> to <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;i" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;k" title="k" /></a> to <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;i" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;j" title="j" /></a>, then the length of this path would be the concatenation of the shortest path from <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;i" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;i" title="i" /></a> to <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;i" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;k" title="k" /></a> (only using intermediate vertices in <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\{1,\ldots&space;,k-1\}}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\{1,\ldots&space;,k-1\}}" title="{\displaystyle \{1,\ldots ,k-1\}}" /></a>) and the shortest path from <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;k" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;k" title="k" /></a> to <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;k" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;j" title="j" /></a> (only using intermediate vertices in <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\{1,\ldots&space;,k-1\}}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\{1,\ldots&space;,k-1\}}" title="{\displaystyle \{1,\ldots ,k-1\}}" /></a>).

If <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;w(i,j)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;w(i,j)}" title="{\displaystyle w(i,j)}" /></a> is the weight of the edge between vertices <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;i" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;i" title="i" /></a> and <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;i" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;j" title="j" /></a>, we can define <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k)}" title="{\displaystyle \mathrm {shortestPath} (i,j,k)}" /></a> in terms of the following recursive formula: the base case is 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,0)=w(i,j)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,0)=w(i,j)}" title="{\displaystyle \mathrm {shortestPath} (i,j,0)=w(i,j)}" /></a>

and the recursive case is

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k)=}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k)=}" title="{\displaystyle \mathrm {shortestPath} (i,j,k)=}" /></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\mathrm&space;{min}&space;{\Big&space;(}\mathrm&space;{shortestPath}&space;(i,j,k-1),}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\mathrm&space;{min}&space;{\Big&space;(}\mathrm&space;{shortestPath}&space;(i,j,k-1),}" title="{\displaystyle \mathrm {min} {\Big (}\mathrm {shortestPath} (i,j,k-1),}" /></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,k,k-1)&plus;\mathrm&space;{shortestPath}&space;(k,j,k-1){\Big&space;)}}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,k,k-1)&plus;\mathrm&space;{shortestPath}&space;(k,j,k-1){\Big&space;)}}" title="{\displaystyle \mathrm {shortestPath} (i,k,k-1)+\mathrm {shortestPath} (k,j,k-1){\Big )}}" /></a>.

This formula is the heart of the Floyd–Warshall algorithm. The algorithm works by first computing <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k)}" title="{\displaystyle \mathrm {shortestPath} (i,j,k)}" /></a> for all <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;(i,j)" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;(i,j)" title="(i,j)" /></a> pairs for <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;k=1" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;k=1" title="k=1" /></a>, then <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;k=1" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;k=2" title="k=2" /></a>, and so on. This process continues until <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;k=1" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;k=N" title="k=N" /></a> , and we have found the shortest path for all <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;(i,j)" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;(i,j)" title="(i,j)" /></a> pairs using any intermediate vertices.

### Analysis
Let <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;n" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;n" title="n" /></a> be <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;|V|" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;|V|" title="|V|" /></a>, the number of vertices. To find all <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;n^{2}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;n^{2}" title="n^{2}" /></a> of <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k)}" title="{\displaystyle \mathrm {shortestPath} (i,j,k)}" /></a> (for all <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;i" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;i" title="i" /></a> and <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;i" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;j" title="j" /></a>) from those of <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k-1)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,k-1)}" title="{\displaystyle \mathrm {shortestPath} (i,j,k-1)}" /></a> requires <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;2n^{2}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;2n^{2}" title="2n^{2}" /></a> operations. Since we begin with <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,0)=\mathrm&space;{edgeCost}&space;(i,j)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,0)=\mathrm&space;{edgeCost}&space;(i,j)}" title="{\displaystyle \mathrm {shortestPath} (i,j,0)=\mathrm {edgeCost} (i,j)}" /></a> and compute the sequence of <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;n" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;n" title="n" /></a> matrices <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,1)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,1)}" title="{\displaystyle \mathrm {shortestPath} (i,j,1)}" /></a>, <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,2)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,2)}" title="{\displaystyle \mathrm {shortestPath} (i,j,2)}" /></a>, <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;\ldots" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;\ldots" title="\ldots" /></a> , <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,n)}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;\mathrm&space;{shortestPath}&space;(i,j,n)}" title="{\displaystyle \mathrm {shortestPath} (i,j,n)}" /></a>, the total number of operations used is <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;{\displaystyle&space;n\cdot&space;2n^{2}=2n^{3}}" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;{\displaystyle&space;n\cdot&space;2n^{2}=2n^{3}}" title="{\displaystyle n\cdot 2n^{2}=2n^{3}}" /></a>. Therefore, the complexity of the algorithm is <a href="https://www.codecogs.com/eqnedit.php?latex=\fn_phv&space;\Theta&space;(n^{3})" target="_blank"><img src="https://latex.codecogs.com/svg.latex?\fn_phv&space;\Theta&space;(n^{3})" title="\Theta (n^{3})" /></a>.