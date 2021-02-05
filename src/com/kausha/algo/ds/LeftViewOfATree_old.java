package com.kausha.algo.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewOfATree_old {

	public static void main(String[] args) {
		GraphNode node = initializeTree();
		printLeftViewOfTree(node);
	}

	// With this approach, we can keep on getting the Left views in slices.
	// It prints all the left views beyond the first left view.
	private static void printLeftViewOfTree(GraphNode node) {
		if(node == null)
			return;
		
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		Queue<GraphNode> queue2 = new LinkedList<GraphNode>();
		queue.add(node);
		queue.add(null);
		
		boolean singlePass = true;
		
		while(!queue.isEmpty() || !queue2.isEmpty()){
			
			if(queue.isEmpty()){
				System.out.println("");
				queue.addAll(queue2);
				queue2.clear();
				singlePass = false;
			}
			
			GraphNode topNode = queue.poll();
			
			if(topNode != null){
				List<GraphNode> nodeList = topNode.getAdjscentNodes();
				if(nodeList != null && singlePass){
					Collections.reverse(nodeList);
					queue.addAll(nodeList);
				}
			}
			
			if(topNode != null){
				if(queue.peek() == null){
					// Got the Left most node
					System.out.print(topNode.value + "  ");
					
					// Remove null from Queue top
					queue.poll();
					
					// Add null to the bottom of the queue if Queue is not null 
					if(!queue.isEmpty())
						queue.add(null);
					
					if(!queue2.isEmpty())
						queue2.add(null);
					
				}else{
					// Add values of the nodes
					queue2.add(topNode);
				}
			}
		}	
	}

	private static GraphNode initializeTree() {
		GraphNode node1 = new GraphNode();
		node1.setValue(6);
		
		GraphNode node2 = new GraphNode();
		node2.setValue(3);
		
		GraphNode node3 = new GraphNode();
		node3.setValue(10);
		
		GraphNode node4 = new GraphNode();
		node4.setValue(7);
		
		List<GraphNode> nodeList1 = new ArrayList<GraphNode>();
		nodeList1.add(node2);
		nodeList1.add(node3);
		nodeList1.add(node4);
		node1.setAdjscentNodes(nodeList1);
		
		
		GraphNode node5 = new GraphNode();
		node5.setValue(5);
		
		GraphNode node6 = new GraphNode();
		node6.setValue(15);
		
		GraphNode node7 = new GraphNode();
		node7.setValue(4);
		
		List<GraphNode> nodeList2 = new ArrayList<GraphNode>();
		nodeList2.add(node5);
		
		List<GraphNode> nodeList3 = new ArrayList<GraphNode>();
		nodeList3.add(node6);
		
		List<GraphNode> nodeList4 = new ArrayList<GraphNode>();
		nodeList4.add(node7);
		
		node2.setAdjscentNodes(nodeList2);
		node3.setAdjscentNodes(nodeList3);
		node4.setAdjscentNodes(nodeList4);
		
		
		
		
		GraphNode node8 = new GraphNode();
		node8.setValue(11);
		
		GraphNode node9 = new GraphNode();
		node9.setValue(17);
		
		GraphNode node10 = new GraphNode();
		node10.setValue(18);
		
		List<GraphNode> nodeList5 = new ArrayList<GraphNode>();
		nodeList5.add(node8);
		
		List<GraphNode> nodeList6 = new ArrayList<GraphNode>();
		nodeList6.add(node9);
		
		List<GraphNode> nodeList7 = new ArrayList<GraphNode>();
		nodeList7.add(node10);
		
		node5.setAdjscentNodes(nodeList5);
		node6.setAdjscentNodes(nodeList6);
		node7.setAdjscentNodes(nodeList7);
		
		
		GraphNode node11 = new GraphNode();
		node11.setValue(13);
		
		GraphNode node12 = new GraphNode();
		node12.setValue(16);
		
		List<GraphNode> nodeList8 = new ArrayList<GraphNode>();
		nodeList8.add(node11);
		nodeList8.add(node12);
		
		node10.setAdjscentNodes(nodeList8);
		
		GraphNode node13 = new GraphNode();
		node13.setValue(20);
		
		GraphNode node14 = new GraphNode();
		node14.setValue(19);
		
		List<GraphNode> nodeList9 = new ArrayList<GraphNode>();
		nodeList9.add(node13);
		nodeList9.add(node14);
		
		node12.setAdjscentNodes(nodeList9);
		
		
		return node1;
	}
}