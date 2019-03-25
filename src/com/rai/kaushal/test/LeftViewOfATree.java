package com.rai.kaushal.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewOfATree {

	public static void main(String[] args) {
		Node node = initializeTree();
		printLeftViewOfTree(node);
	}

	private static void printLeftViewOfTree(Node node) {
		if(node == null)
			return;
		
		Queue<Node> queue = new LinkedList<Node>();
		
		Queue<Node> queue2 = new LinkedList<Node>();
		
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
			
			Node topNode = queue.poll();
			
			if(topNode != null){
				List<Node> nodeList = topNode.nodeList;
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

	private static Node initializeTree() {
		Node node1 = new Node();
		node1.setValue(6);
		
		Node node2 = new Node();
		node2.setValue(3);
		
		Node node3 = new Node();
		node3.setValue(10);
		
		Node node4 = new Node();
		node4.setValue(7);
		
		List<Node> nodeList1 = new ArrayList<Node>();
		nodeList1.add(node2);
		nodeList1.add(node3);
		nodeList1.add(node4);
		node1.setNodeList(nodeList1);
		
		
		Node node5 = new Node();
		node5.setValue(5);
		
		Node node6 = new Node();
		node6.setValue(15);
		
		Node node7 = new Node();
		node7.setValue(4);
		
		List<Node> nodeList2 = new ArrayList<Node>();
		nodeList2.add(node5);
		
		List<Node> nodeList3 = new ArrayList<Node>();
		nodeList3.add(node6);
		
		List<Node> nodeList4 = new ArrayList<Node>();
		nodeList4.add(node7);
		
		node2.setNodeList(nodeList2);
		node3.setNodeList(nodeList3);
		node4.setNodeList(nodeList4);
		
		
		
		
		Node node8 = new Node();
		node8.setValue(11);
		
		Node node9 = new Node();
		node9.setValue(17);
		
		Node node10 = new Node();
		node10.setValue(18);
		
		List<Node> nodeList5 = new ArrayList<Node>();
		nodeList5.add(node8);
		
		List<Node> nodeList6 = new ArrayList<Node>();
		nodeList6.add(node9);
		
		List<Node> nodeList7 = new ArrayList<Node>();
		nodeList7.add(node10);
		
		node5.setNodeList(nodeList5);
		node6.setNodeList(nodeList6);
		node7.setNodeList(nodeList7);
		
		
		Node node11 = new Node();
		node11.setValue(13);
		
		Node node12 = new Node();
		node12.setValue(16);
		
		List<Node> nodeList8 = new ArrayList<Node>();
		nodeList8.add(node11);
		nodeList8.add(node12);
		
		node10.setNodeList(nodeList8);
		
		Node node13 = new Node();
		node13.setValue(20);
		
		Node node14 = new Node();
		node14.setValue(19);
		
		List<Node> nodeList9 = new ArrayList<Node>();
		nodeList9.add(node13);
		nodeList9.add(node14);
		
		node12.setNodeList(nodeList9);
		
		
		return node1;
	}
}

class Node{
	int value;
	
	List<Node> nodeList;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Node> getNodeList() {
		return nodeList;
	}

	public void setNodeList(List<Node> nodeList) {
		this.nodeList = nodeList;
	}

	@Override
	public String toString() {
		//return "Node [value=" + value + ", nodeList=" + nodeList + "]";
		return value + "" ;
	}
}