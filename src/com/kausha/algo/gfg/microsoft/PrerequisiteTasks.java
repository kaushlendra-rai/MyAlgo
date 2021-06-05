package com.kausha.algo.gfg.microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class PrerequisiteTasks {
	public static void main(String[] args) {
		PrerequisiteTasks pt = new PrerequisiteTasks();

		//int[][] prerequisites = new int[][] {{1,0},{2,1},{3,2}}; // true
		//System.out.println(pt.isPossible(4, prerequisites));
		
		int[][] prerequisites2 = new int[][] {{1,0},{0, 1}}; // false
		System.out.println(pt.isPossible(2, prerequisites2));
	}

	public boolean isPossible(int N, int[][] prerequisites)
    {
		// Values in visited Map: 0 - unvisited, 1 - working on it, 2 - done visiting it.
		Map<Integer, Integer> visited = new HashMap<>();
		// We traverse DF and check for cycle.
		Map<Integer, List<Integer>> graph = new HashMap<>();
		
		for(int i=0; i<prerequisites.length; i++) {
			List<Integer> adj = graph.get(prerequisites[i][1]);
			if(adj != null) {
				adj.add(prerequisites[i][0]);
			}else {
				adj = new ArrayList<>();
				adj.add(prerequisites[i][0]);
			}
			graph.put(prerequisites[i][1], adj);
			visited.put(prerequisites[i][1], 0);
			visited.put(prerequisites[i][0], 0);
		}
		
//		visited.forEach((k, v) -> System.out.println("key: " + k + " , Value: " + v));
//		System.out.println("\ngraph::");
//		graph.forEach((k, v) -> System.out.println("key: " + k + " , Value: " + v));
		for(int key : visited.keySet()) {
			if(!isPossible(graph, visited, key))
				return false;
		}
		return true;
    }
	
	private boolean isPossible(Map<Integer, List<Integer>> graph, Map<Integer, Integer> visited, int currentValue) {
		// The node has already been visited, so return from here.
		if(visited.get(currentValue) == 2)
			return true;
		
		// The current node is already in traversal and visiting it indicates there is a circular loop. Hence tasks not possible.
		if(visited.get(currentValue) == 1)
			return false;
		
		// Lets start traversing.
		visited.put(currentValue, 1);
		
		if(graph.get(currentValue) != null)
			for(int val : graph.get(currentValue)) {
				if(!isPossible(graph, visited, val))
					return false;
			}
		
		visited.put(currentValue, 2);
		return true;
	}
}
