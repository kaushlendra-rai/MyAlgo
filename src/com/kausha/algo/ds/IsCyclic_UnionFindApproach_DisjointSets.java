package com.kausha.algo.ds;

import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=eTaWFhPXPz4&t=166s

// It MUST be noted that this approach works only for undirected graphs.
// This is true basically due to the way we do a UNION of the two disjoint sets.
// We follow up to the top parent of both sets and then we connect one set's parent as child of another.
// and the respective nodes
public class IsCyclic_UnionFindApproach_DisjointSets {

	public static void main(String[] args) {
		IsCyclic_UnionFindApproach_DisjointSets ic = new IsCyclic_UnionFindApproach_DisjointSets();
		//int[][] tuples = new int[][] {{1, 2}, {2, 3}, {4, 5}, {5, 6}}; // no cycle
		 int[][] tuples = new int[][] {{1, 2}, {2, 3}, {4, 5}, {5, 6}, {1, 3}}; // cyclic 1->2->3->1
		
		System.out.println("Is cyclic: " + ic.isCyclic(tuples));
	}
	
	public boolean isCyclic(int[][] tuples) {
		int[] parents = new int[tuples.length*2+1];
		// Before joining, we treat first element of the node as top level parent in isolation. 
		for(int i=0; i< parents.length; i++)
			parents[i]= -1;
		
		for(int i=0; i< tuples.length; i++) {
			int firstParent = find(parents, tuples[i][0]);
			int secondParent = find(parents, tuples[i][1]);
			
			if(firstParent == secondParent)
				return true;
			
			union(parents, tuples[i]);
		}
		
		return false;
	}

	// In the union, we join the parent of number at index '0' with parent of number at index '1'.
	private void union(int[] parents, int[] tuple) {
		int first = find(parents, tuple[0]);
		int second = find(parents, tuple[1]);
		
		parents[first] = second; 
	}

	private int find(int[] parents, int i) {
		if(parents[i] == -1)
			return i;
		
		return find(parents, parents[i]);
	}

}
