package com.kausha.algo.ds;

public class BSTToDoubleLinkedList {
	public static void main(String[] args) {
		TreeNode root = DSUtil.getBinaryTree();
		DSUtil.printTreeRecursively(root);
		System.out.println("\n");
		TreeNode dllList = bstToDDL(root);
		DSUtil.printCircularDLL(dllList);
	}
	
	private static TreeNode bstToDDL(TreeNode node) {
		
		if(node == null)
			return null;
		
		TreeNode left = bstToDDL(node.left);
		TreeNode right = bstToDDL(node.right);
		
		node.left = node;
		node.right = node;
		
		left = mergeNodes(left, node);
		left = mergeNodes(left, right);
		
		return left;
	}

	private static TreeNode mergeNodes(TreeNode left, TreeNode right) {
		if(left== null)
			return right;
		
		if(right == null)
			return left;
		
		TreeNode right_left = right.left;
		
		left.left.right = right;
		right.left = left.left;
		
		right_left.right = left;
		
		left.left = right_left;
		
		return left;
	}
}