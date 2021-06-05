package com.kausha.algo.gfg.microsoft;

import java.util.ArrayList;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/inorder-traversal-iterative
public class BTInOrderTraversal_Iterative {

	public static void main(String[] args) {
		BTInOrderTraversal_Iterative bio = new BTInOrderTraversal_Iterative();
		
		Node root = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		
		System.out.println(bio.inOrder(root));
	}

	ArrayList<Integer> inOrder(Node root)
    {
		ArrayList<Integer> nums = new ArrayList<>();
		if(root == null)
			return nums;
		
		Stack<Node> stack = new Stack<>();
		while(root != null) {
			stack.push(root);
			root = root.left;
		}
			
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			
			nums.add(node.data);
			node = node.right;
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		
		return nums;
    }
}
