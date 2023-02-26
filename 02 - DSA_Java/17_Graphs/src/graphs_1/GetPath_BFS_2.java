package graphs_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Video Explanation - https://leetcode.com/explore/learn/card/graph/620/breadth-first-search-in-graph/3852/
//Time Complexity: Adjacency List: O(V + E) | Adjacency Matrix: O(R * C)
//Space Complexity: O(V)
public class GetPath_BFS_2 {
	private static String getPath_BFS(int[][] edges, int n, int[] visited, int v1, int v2) {
		Queue<String> pendingVertices = new LinkedList<>();
		pendingVertices.add(Integer.toString(v1));
		visited[v1] = 1;
		while(!pendingVertices.isEmpty()) {
			String p = pendingVertices.poll();
			int vertex = Integer.parseInt(p.substring(p.length() - 1));
			if(vertex == v2) {
				return p;
			}
			for(int i = 0; i < n; i++) {
				if(i != vertex && edges[vertex][i] == 1 && visited[i] == 0) {
					//Make sure not traversing the own self, there is an edge, the verticle is not visited. Only then traverse this verticle
					visited[i] = 1;
					String path = p + Integer.toString(i);
					pendingVertices.add(path);
				}
			}
		}
		return pendingVertices.peek();
	}
	
	private static String getPath(int[][] edges, int n, int[] visited, int v1, int v2) {
		String path = "";
		
		for(int i = 0; i < visited.length; i++) {
			if(visited[i] == 0 && i == v1) {
				path = getPath_BFS(edges, n, visited, v1, v2);
			}
		}
		
		return path;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // number of vertices [0...n-1]
	    int e = sc.nextInt(); // number of edges
	    // Creating the adjacency matrix
	    int[][] edges = new int[n][n];
	    // Filling the adjacency matrix with proper edges
	    for(int i = 0; i < e; i++) {
	        int f = sc.nextInt(), s = sc.nextInt(); // first and second vertices
	        // As it is a bidirectional/undirectional graph so it will have edges from first vertices to second vertices and vice-versa
	        edges[f][s] = 1;
	        edges[s][f] = 1;
	    }
		
	    int v1 = sc.nextInt(), v2 = sc.nextInt();
	    int[] visited = new int[n];
	    String path = getPath(edges, n, visited, v1, v2);
	    System.out.println(path);
	}

}
