package com.kausha.algo.ds;

import java.util.Stack;

public class BSTPreorderTraversalIterative {
	public static void main(String[] args) {
		TreeNode root = DSUtil.getBinaryTree();
		DSUtil.printTreeRecursively(root);
		System.out.println("\n");
		inorderTraversal(root);
	}

	private static void inorderTraversal(TreeNode root) {
		if(root == null)
			return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.println(node.value);
			if(node.right != null)
				stack.push(node.right);
			if(node.left != null)
				stack.push(node.left);
		}
	}
}
