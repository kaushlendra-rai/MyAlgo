package com.kausha.algo.ds;

public class RemoveTreeNodesLyingOutOfRange_old {

	public static void main(String[] args) {
		TreeNode node = DSUtil.getBinaryTree();
		DSUtil.printTree(node);
		TreeNode result = removeNodesOutOfRange(node, 50, 22);
		System.out.println("*******  " + result.value);
		System.out.println("Result : ");
		DSUtil.printTree(result);
	}
	
	public static TreeNode removeNodesOutOfRange(TreeNode node, int max, int min){
		if(node == null)
			return null;
		
		node.left = removeNodesOutOfRange(node.left, max, min);
		node.right = removeNodesOutOfRange(node.right, max, min);
		
		
		if(node.value <  min)
			node = node.right;
		
		if(node != null && node.value > max)
			node = node.left;
		
		return node;
	}
}