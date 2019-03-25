package com.kausha.algo.ds;


// http://www.crazyforcode.com/node-left-right-subtree/
public class BSTReplaceNodeWithSumLeftRightNode {
	public static void main(String[] args) {
		TreeNode node = DSUtil.getBinaryTree();
		
		System.out.println(replaceNodeWithSumOfLeftRightNode(node));
	}

	private static int replaceNodeWithSumOfLeftRightNode(TreeNode node) {
		if(node == null)
			return 0;
		
		int left = replaceNodeWithSumOfLeftRightNode(node.left);
		int right = replaceNodeWithSumOfLeftRightNode(node.right);
		
		node.value = left + right + node.value;
		
		return node.value;
	}	
}