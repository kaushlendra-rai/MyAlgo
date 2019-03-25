package com.kausha.algo.ds;

public class DiameterOfABinaryTree {
	public static void main(String[] args) {
		TreeNode root = DSUtil.getBinaryTree2();
		Object[] diameterInfo = findTreeDepth(root);
		
		//System.out.println("Depth of Tree = " + diameterInfo[0]);
		System.out.println("Tree Diameter = " + diameterInfo[0]);
		//System.out.println("Tree Diameter End-points= " + ((TreeNode)diameterInfo[2]).value + "  ,  " + ((TreeNode)diameterInfo[3]).value);
	}

	private static Object[] findTreeDepth(TreeNode root) {
		Object[] diameter = new Object[1];
		diameter[0] = 0;
		
		if(root==null)
			return diameter;
		
		findDepth(root, diameter);
		return diameter;
	}

	private static int findDepth(TreeNode node, Object[] diameter) {
		if(node == null)
			return 0;
		
		int left = findDepth(node.left, diameter);
		int right = findDepth(node.right, diameter);
		
		int dia = (Integer)diameter[0];
		if(left + right +1 > dia)
			diameter[0] = left+right + 1;
		
		return left > right ? left+1 : right+1;
	}
}