package com.kausha.algo.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

// https://www.geeksforgeeks.org/topological-sorting/
// Teh geekforgeeks solution is wrong.
public class DAGDependencyResolution {

	public static void main(String[] args) {
		GraphNode root = DSUtil.getGraph();
		Map<Integer, List<Integer>> tuples = new HashMap<Integer, List<Integer>>();
		tuples.put(1, Arrays.asList(2, 3, 4));
		tuples.put(2, Arrays.asList(5));
		tuples.put(3, Arrays.asList(5));
		tuples.put(4, null);
		//tuples.put(4, Arrays.asList(1));
		tuples.put(5, new ArrayList());
		
		tuples.put(8, Arrays.asList(9));
		tuples.put(9, null);
		System.out.println(constructDirectedAcyclicGraph(tuples));
	}

	// This method constructs a DAG graph and reports an error in case of Cyclic graph is found.
	// 0 - White - unvisited
	// 1 - Grey - Being processed
	// 2 - Black - Processing complete. This node can no more be a part of Cyclic dependency.
	public static String constructDirectedAcyclicGraph(Map<Integer, List<Integer>> tuples) {
		Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
		for(Integer num: tuples.keySet())
			visited.put(num, 0);
		// This set does not contain any node from a cyclic Graph.
		Set<Integer> startingPoints = findStartingNodesForDAG(tuples);
		
		Stack<Integer> stack = new Stack<Integer>();
		for(Integer key: startingPoints) 
			DAGTraversal(key, visited, stack, tuples);
		
		// The stack might have lesser nodes in case there was a cyclic graph in tuples.
		if(stack.size() != tuples.size())
			return "Cyclic dependency exists";
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty())
			sb.append(stack.pop() + " ");
		
		return sb.toString();
	}
	
	private static int DAGTraversal(Integer key, Map<Integer, Integer> visited, Stack<Integer> stack, Map<Integer, List<Integer>> tuples) {
		// If the node has already been visited, do NOT process it again.
		if(visited.get(key) > 0)
			return visited.get(key);
		
		stack.push(key);
		visited.put(key, 1);
		
		if(tuples.get(key) != null && !tuples.get(key).isEmpty())
			for(Integer num : tuples.get(key))
				if(DAGTraversal(num, visited, stack, tuples) == 1) // This is a case of cyclic dependency and MUST stop traversal from this node.
					return 1;
		
		visited.put(key, 2);
		return 2;
	}
	
	// This method can find starting points for DAG in Forest (multiple trees) provided there are no Cyclic dependencies.
		// It would not be able to detect Cyclic dependencies.
		private static Set<Integer> findStartingNodesForDAG(Map<Integer, List<Integer>> tuples) {
			Set<Integer> startingPoint = new HashSet<Integer>(tuples.keySet());
			
			for(Integer key : tuples.keySet())
				if(tuples.get(key) != null)
					startingPoint.removeAll(tuples.get(key));
			
			return startingPoint;
		}
}