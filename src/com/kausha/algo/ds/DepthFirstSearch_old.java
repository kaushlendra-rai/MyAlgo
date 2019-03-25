package com.kausha.algo.ds;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch_old {

	public static void main(String[] args) {
		GraphNode root = getGraph();
		System.out.println(depthFirstSearch(root, 7));
	}

	public static boolean depthFirstSearch(GraphNode node, int num){
		if(node == null)
			return false;
		
		Stack<GraphNode> stack = new Stack<GraphNode>();
		Set<GraphNode> status = new HashSet<GraphNode>();
		
		stack.push(node);
		
		while(!stack.isEmpty()){
			GraphNode temp = stack.pop();
			System.out.println("**  traversal = " + temp.getValue());
			if(temp.value == num){
				return true;
			}else{
				if(!status.contains(temp)){
					List<GraphNode> adjNodes = temp.getAdjscentNodes();
					
					if(adjNodes != null)
						for(GraphNode adjNode : adjNodes){
							if(!status.contains(adjNode)){
								stack.push(adjNode);
							}
						}
					
					status.add(temp);
				}
			}
		}
		
		return false;
	}
	
	private static GraphNode getGraph(){
		GraphNode root = new GraphNode(20);
		GraphNode Node1 = new GraphNode(22);
		GraphNode Node2 = new GraphNode(32);
		GraphNode Node3 = new GraphNode(24);
		List<GraphNode> adj1 = new ArrayList<GraphNode>();
		adj1.add(Node1);
		adj1.add(Node2);
		adj1.add(Node3);
		root.setAdjscentNodes(adj1);
		
		
		GraphNode Node4 = new GraphNode(26);
		GraphNode Node5 = new GraphNode(7);
		
		List<GraphNode> adj2 = new ArrayList<GraphNode>();
		adj2.add(Node4);
		adj2.add(Node5);
		adj2.add(Node2);
		Node1.setAdjscentNodes(adj2);
		
		GraphNode Node6 = new GraphNode(52);
		GraphNode Node7 = new GraphNode(552);
		
		List<GraphNode> adj3 = new ArrayList<GraphNode>();
		adj3.add(Node6);
		adj3.add(Node7);
		adj3.add(Node5);
		Node4.setAdjscentNodes(adj3);
		
		return root;
	}
}