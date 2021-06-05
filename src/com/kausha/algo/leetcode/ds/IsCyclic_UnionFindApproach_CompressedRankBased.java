package com.kausha.algo.leetcode.ds;

import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=kaBX2s3pYO4

// It MUST be noted that this approach works only for undirected graphs.
// This is true basically due to the way we do a UNION of the two disjoint sets.
// We follow up to the top parent of both sets and then we connect one set's parent as child of another.
// and the respective nodes
// Here we use Union-by-rank and Compression to reduce the Find & Union operation's time complexity.
public class IsCyclic_UnionFindApproach_CompressedRankBased {

	public static void main(String[] args) {
		IsCyclic_UnionFindApproach_CompressedRankBased ic = new IsCyclic_UnionFindApproach_CompressedRankBased();
		// int[][] tuples = new int[][] {{1, 2}, {2, 3}, {4, 5}, {5, 6}}; // no cycle
		int[][] tuples = new int[][] {{1, 2}, {2, 3}, {4, 5}, {5, 6}, {1, 3}}; // cyclic 1->2->3->1
		
		System.out.println("Is cyclic: " + ic.isCyclic(tuples));
	}
	
	public boolean isCyclic(int[][] tuples) {
		Tuple[] parents = new Tuple[tuples.length*2+1];
		// Before joining, we treat first element of the node as top level parent in isolation. 
		for(int i=0; i< parents.length; i++) {
			Tuple tuple = new Tuple();
			tuple.parent = -1;
			tuple.rank = 0;
			parents[i]= tuple;
		}
		
		for(int i=0; i< tuples.length; i++) {
			int firstParent = find(parents, tuples[i][0]);
			int secondParent = find(parents, tuples[i][1]);
			
			if(firstParent == secondParent)
				return true;
			
			union(parents, tuples[i]);
		}
		
		return false;
	}

	// In the union, we join the parent of node with lower rank to parent of higher rank.
	// This is done to ensure that the height of the tree is minimal, hence minimal traversal to 'find'.
	private void union(Tuple[] parents, int[] tuple) {
		int first = find(parents, tuple[0]);
		int second = find(parents, tuple[1]);
		// We 
		if(parents[first].rank == parents[second].rank) {
			parents[first].rank++;
			parents[second].parent = first;
		}else if(parents[first].rank > parents[second].rank) {
			parents[second].parent = first; 
		}else {
			parents[first].parent = second; 
		}
	}

	private int find(Tuple[] parents, int i) {
		if(parents[i].parent == -1)
			return i;
		// The below step is compression step. We are changing the parent of a node to absolute parent of set.
		int parent = find(parents, parents[i].parent);
		parents[i].parent = parent;
		return parent;
	}
}

class Tuple{
	int parent;
	int rank;
}