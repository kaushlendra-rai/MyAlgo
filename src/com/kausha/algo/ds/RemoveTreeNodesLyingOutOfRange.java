package com.kausha.algo.ds;

public class RemoveTreeNodesLyingOutOfRange {
	public static void main(String[] args) {
		TreeNode node = DSUtil.getBinaryTree();
		DSUtil.printTree(node);
		TreeNode result = removeNodesOutOfRange(node, 22, 50);
		System.out.println("*******  " + result.value);
		System.out.println("Result : ");
		DSUtil.printTree(result);
	}

	private static TreeNode removeNodesOutOfRange(TreeNode node, int min, int max) {
		if(node == null)
			return null;
		
		if(node.value >= min && node.value <= max){
			node.left = removeNodesOutOfRange(node.left, min, max);
			node.right = removeNodesOutOfRange(node.right, min, max);
		}else if(node.value < min){
			node = removeNodesOutOfRange(node.right, min, max);
		}else if(node.value > max){
			node = removeNodesOutOfRange(node.left, min, max);
		}
		
		return node;
	}
}