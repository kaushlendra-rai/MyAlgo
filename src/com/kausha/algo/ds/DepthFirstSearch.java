package com.kausha.algo.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
	public static void main(String[] args) {
		GraphNode root = DSUtil.getGraph();
		//System.out.println(depthFirstSearch(root, 52));
		System.out.println(depthFirstSearch(root, 32));
	}
	
	private static boolean depthFirstSearch(GraphNode root, int i) {
		
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			GraphNode node = stack.pop(); 
			if(node.value == i){
				System.out.println("Match Found");
				return true;
			}
		
			List<GraphNode> adj = node.getAdjscentNodes();
			System.out.println("value = " + node.value);
		
			if(adj != null){
				stack.addAll(adj);
			}
		}
		
		return false;
	}	
}