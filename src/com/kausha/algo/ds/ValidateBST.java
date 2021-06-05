package com.kausha.algo.ds;

public class ValidateBST {
	public static void main(String[] args) throws Exception{
		TreeNode node = DSUtil.getBinaryTree();
		System.out.println("Tree validity = " + isValidBST(node));
	}
	
	public static boolean isValidBST(TreeNode node) throws Exception{
		if(node == null)
			throw new Exception("Node is null");
		
		return valiadteBST(node, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	private static boolean valiadteBST(TreeNode node, long min, long max){
		if(node == null)
			return true;
		
		if(node.value >= min && node.value <= max){
			return valiadteBST(node.left, min, node.value) && valiadteBST(node.right, node.value, max);
		}else
			return false;
	}
}