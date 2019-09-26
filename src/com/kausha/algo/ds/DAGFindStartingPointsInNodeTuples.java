package com.kausha.algo.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DAGFindStartingPointsInNodeTuples {
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
		System.out.println(findStartingNodesForDAG(tuples));
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
