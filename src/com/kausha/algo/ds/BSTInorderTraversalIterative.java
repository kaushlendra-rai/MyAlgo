package com.kausha.algo.ds;

import java.util.Stack;

public class BSTInorderTraversalIterative {
	public static void main(String[] args) {
		TreeNode root = DSUtil.getBinaryTree();
		DSUtil.printTreeRecursively(root);
		System.out.println("\n");
		inorderTraversal(root);
	}

	private static void inorderTraversal(TreeNode root) {
		if (root == null)
			return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(root != null) {
			stack.push(root);
			root = root.left;
		}
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.println(node.value);
			TreeNode right = node.right;
			
			while(right != null) {
				stack.push(right);
				right = right.left;
			}
		}
		
	}
}
