package graphs_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Video Explanation - https://leetcode.com/explore/learn/card/graph/619/depth-first-search-in-graph/3848/
//Time Complexity: Adjacency List: O(V + E) | Adjacency Matrix: O(R * C)
//Space Complexity: O(V)

public class GetPath_DFS_2 {
	private static List<Integer> getPath_DFS(int[][] edges, int n, int[] visited, int v1, int v2) {
		List<Integer> path = new ArrayList<>();
		visited[v1] = 1;
		if(v1 == v2) {
			path.add(v1);
			return path;
		}
		for(int i = 0; i < n; i++) {
			if(i == v1) {
				//No need to visit the same verticle from which we are traversing
				continue;
			} else {
				if(edges[v1][i] == 1 && visited[i] == 0) {
					//This will hold the list of vertices
					path = getPath_DFS(edges, n, visited, i, v2);
					if(path.size() != 0) {
						//There is some vertices in path, that means we found the final verticle through DFS
						path.add(v1);
						return path;
					}
				}
			}
		}
		//Mark the vertices as unvisited as other paths might traverse through this verticle
		visited[v1] = 0; 
		return path;
	}
		
	
	private static List<Integer> getPath(int[][] edges, int n, int[] visited, int v1, int v2) {
		List<Integer> shortestPath = new ArrayList<>();
		int minPathSize = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			//Running this for loop to make sure that there are no disconnected components that are missed.
			if(visited[i] == 0 && i == v1) {
				List<Integer> path = getPath_DFS(edges, n, visited, i, v2);
				if(path.size() != 0 && minPathSize > path.size()) {
					shortestPath = path;
				}
			}
		}
		
		return shortestPath;
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
	    List<Integer> path = getPath(edges, n, visited, v1, v2);
	    if(path.size() != 0) {
	    	Collections.reverse(path);
	    	System.out.println(path);
	    } else {
	    	System.out.println("There is no path");
	    }
	}

}
