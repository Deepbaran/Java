package graphs_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
	
	private static void print_DFS(int[][] edges, int n, int sv, boolean[] visited) {
	    System.out.print(sv + " ");
	    visited[sv] = true; // mark as visited
	    for(int i = 0; i < n; i++) {
	        if(i == sv) {
	            continue;
	        }
	        if(edges[sv][i] == 1) {
	            // Check if i is already been visied or not
	            if(visited[i]) {
	                continue;
	            }
	            // if there is an edge between the starting vertex and i then call print again with i as starting vertex
	            print_DFS(edges, n, i, visited);
	        }
	    }
	}

	private static void print_BFS(int[][] edges, int n, int sv, boolean[] visited) {
	    // It is similar to level order traversal in tree
	    Queue<Integer> pendingVertices = new LinkedList<>();
	    pendingVertices.add(sv);
	    visited[sv] = true;
	    while(!pendingVertices.isEmpty()) {
	        int currentVertex = pendingVertices.peek();
	        pendingVertices.poll();
	        System.out.print(currentVertex + " ");
	        for(int i = 0; i < n; i++) {
	            if(i == currentVertex) {
	                continue;
	            }
	            if(edges[currentVertex][i] == 1 && !visited[i]) {
	                pendingVertices.add(i);
	                visited[i] = true;
	            }
	        }
	    }
	}

	private static void DFS(int[][] edges, int n) {
	    boolean[] visited = new boolean[n];
	    for(int i = 0; i < n; i++) {
	        visited[i] = false;
	    }
	    for(int i = 0; i < n; i++) {
	        if(!visited[i])
	            print_DFS(edges, n, i, visited);
	    }
	}

	private static void BFS(int[][] edges, int n) {
	    boolean[] visited = new boolean[n];
	    for(int i = 0; i < n; i++) {
	        visited[i] = false;
	    }
	    for(int i = 0; i < n; i++) {
	        if(!visited[i])
	            print_BFS(edges, n, i, visited);
	    }
	}

	public static void main(String[] args) {
		int n; // number of vertices
		int e; // number of edges
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		e = s.nextInt();
		int edges[][] = new int[n][n]; // adjacency matrix.
		for(int i=0; i<e; i++) {
			int fv = s.nextInt(); // first vertex
			int sv = s.nextInt(); // second vertex
	        // As it is a bidirectional/undirectional graph so it will have edges from first vertices to second vertices and vice-versa
			edges[fv][sv] = 1; // edge directed from fv to sv
			edges[sv][fv] = 1; // edge directed from sv to fv
		}
		
		/*
		// For Connected Graphs
		// We need a visited array so that we do not traverse through the nodes that we already traversed through
	    boolean[] visited = new boolean[n];
	    for(int i = 0; i < n; i++) {
	        visited[i] = false;
	    }
	    // This is DFS traversal
	    System.out.print("DFS: "); 
	    print_DFS(edges, n, 0, visited); // 0 is the starting vertex for printing the graph
	    System.out.println();

	    // Reset the visited array
	    for(int i = 0; i < n; i++) {
	        visited[i] = false;
	    }
	    // BFS traversal
	    System.out.print("BFS: ");
	    print_BFS(edges, n, 0, visited);
	    System.out.println();
	    */
		
		// For Disconnected Graphs
		System.out.print("DFS: ");
	    DFS(edges, n);
	    System.out.println();
	    System.out.print("BFS: ");
	    BFS(edges, n);
	    System.out.println();
	}

}


/*
NOTES:

* Graphs:  A graph is a set of vertices and the edges connecting them. Graphs are used in a lot of the real life cases. For example, 
i> in case of facebook let's say that each user is a node(vertex) and they are connected between them. The connection between them will be edges. So, if we wish to connect different people in a social media, we will be using graphs. 
ii> Roads connecting different cities is a example of graph.
iii> Tree is also a graph but it is a special king of graph. Tree is a acyclic(does not contain any cycles) connected(all nodes are connected to eah other) graph.

* Adjacent Vertices: Two vertices are called adjacent if they have a direct edge between them.

* Degree: The number of edges connected to a vertices is the degree of that vertex.

* Path: Collection of edges through which we can reach from one point to another

* Connected graph: For every two vertices, there is a path between them.

* Connected Components: Components consists of vertices and edges. And all the components make a graph. Each component is not connected to each other.

* Tree: Tree is a connected graph which does not have any cycle

* A graph with n vertices will have minimum 0 edges for a graph and n-1 edges(O(n) time complexity) for a connected graph(A graph with minimum number of edges is basically a Tree)

* A complete graph(every vertex has a edge with every other vertex) with n vertices will have minimum number of nC2 i.e, (n*(n-1)/2) edges(O(n^2) time complexity). 

* DFS [Depth First Search]: It means once we go into one direction, we will keep going into depth till the point we can't go anymore.

* The minimum number of edges in a connected graph is of order O(n) and the maximum number of edges in a connected graph is of order O(n^2), where n is the number of vertices. So, any algorithm that works in terms of number of edges then it's time complexity for worst case will be O(n^2). So, any algorithm that works in terms of number of edges then it works quadratically rather than linearly.

* BFS [Breadth First Search]: It's similar to level order traversal in trees

* Directed Graphs: A graph with directed edges. that means, edges[i][j] = 1 does not necessarily imply, edges[j][i] = 1

* Weighted Graphs: Edges have values/weightage/importance. [e.g: Length of the road connecting two roads]
    edges[i][j] = edge of the weight

*/

/*
Trees is a special kind of graph with two distinct features:
1. Tree cannot have disjoint sets. Each node must be connected either directly or indirectly.
2. Tree cannot have cycles. (Trees are acyclic)

If we have an algorithm which runs in terms of edges, then in the worst case, it's time complexity will be O(E) => O(N^2)
As Time complexity of Edges is O(N^2).

If we have an algorithm which runs in terms of vertices, then in the worst case, it's time complexity will be O(V) => O(N)
As Time complexity of vertices is O(N).

Representing a Graph:
1. Edge List: In this case we will put pair of vertices, having edge between them, in a list. Time complexity of figuring out if there is an edge between two vertices: O(n^2) [Same as time complexity of Edges]
2. Adjacency List: In this case we will have a list of all the vertices and each vertices will have their own list of vertices that they are connected to by edges. Time complexity of finding if two vertices have edges between them: O(n) [Time taken to traverse the list of the respective vertices]
3. Adjacency Matrix: If there are n vertices then we will create a matrix of n X n and the cess (i, j) will tell us if there is an edge between vertices i and j. It is easy to implement. The downside of Adjacency list is it takes O(n^2) space. In case of Sparse graph (graph with very few edges), the matrix will be filled with a lot of 0s.

Time complexity wise, use Adjacency Matrix.
Space Complexity wise, use Adjacency List.

Shortest Path Finding Algorithms:
1. Unweighted graph: BFS
2. Weighed Graph: Dijkstra (Greedy BFS)
*/

/*
All Connected Components: DFS
IsConnected: DFS
Has Path (Shortest Path/Path Search for un-weighted undirectional graph): BFS
*/