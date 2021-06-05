package com.kausha.algo.gfg.microsoft;

import java.util.ArrayList;
import java.util.Stack;

public class BTPostOrderTraversal {

	public static void main(String[] args) {
		BTPostOrderTraversal pot = new BTPostOrderTraversal();

		Node root = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		System.out.println(pot.postOrder(root));
	}

	// Iterative approach.
	ArrayList<Integer> postOrder(Node root) {
		ArrayList<Integer> nums = new ArrayList<>();
		if(root == null)
			return nums;
		
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			if(node.left != null)
				stack.push(node.left);
			if(node.right != null)
				stack.push(node.right);
			
			nums.add(node.data);
		}

		// Reverse the order of nums in place.
		for(int i=0; i < nums.size()/2; i++) {
			int temp = nums.get(i);
			nums.set(i, nums.get(nums.size()-1-i));
			nums.set(nums.size()-1-i, temp);
		}
		
		return nums;
	}
	
	// Recursive approach.
	ArrayList<Integer> postOrder_recursive(Node node) {
		ArrayList<Integer> nums = new ArrayList<>();
		postOrder(node, nums);
        return nums;
    }
	
	void postOrder(Node node, ArrayList<Integer> nums){
		if(node == null)
			return;
		
		postOrder(node.left, nums);
		postOrder(node.right, nums);
		
		nums.add(node.data);
	}
	
}
