package com.kausha.algo.ds;

public class DepthOfATree_old {

	public static void main(String[] args) {
		TreeNode root = DSUtil.getBinaryTree();
		int depth = findTreeDepth(root);
		
		System.out.println("Tree Depth = " + depth);
	}
	
	private static int findTreeDepth(TreeNode node){
		if(node == null)
			return 0;
		
		int[] depth = new int[1];
		findTreeDepth(node, depth);
		
		return depth[0]; 
	}

	private static void findTreeDepth(TreeNode node, int[] depth) {
		if(node == null){
			depth[0] = 0;
			return;
		}
		
		// Parse left node
		findTreeDepth(node.left, depth);
		int leftDepth = depth[0];
		
		// Parse right node
		findTreeDepth(node.right, depth);
		int rightDepth = depth[0];
		
		depth[0] = leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
	}	
}