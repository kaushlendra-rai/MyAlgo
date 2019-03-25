package com.kausha.algo.ds;

public class DepthOfATree {
	public static void main(String[] args) {
		TreeNode root = DSUtil.getBinaryTree();
		int depth = findTreeDepth(root);
		
		System.out.println("Tree Depth = " + depth);
	}

	private static int findTreeDepth(TreeNode node) {
		if(node == null)
			return 0;
		
		int depth = 1;
		int left = findTreeDepth(node.left);
		int right = findTreeDepth(node.right);
		
		depth += left > right ? left : right;
		
		return depth;
	}
}
