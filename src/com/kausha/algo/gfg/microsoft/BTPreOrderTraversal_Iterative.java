package com.kausha.algo.gfg.microsoft;

import java.util.ArrayList;
import java.util.Stack;

public class BTPreOrderTraversal_Iterative {

	public static void main(String[] args) {
		BTPreOrderTraversal_Iterative bpt = new BTPreOrderTraversal_Iterative();
		
		Node root = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		System.out.println(bpt.preOrder(root));

	}

	ArrayList<Integer> preOrder(Node root)
    {
		ArrayList<Integer> nums = new ArrayList<>();
		
		if(root == null)
			return nums;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			
			while(node != null) {
				nums.add(node.data);
				if(node.right != null)
					stack.push(node.right);
				node = node.left;
			}
		}
		
        return nums;
    }
}
