package com.kausha.algo.ds;

public class BSTMirrorImages {
	public static void main(String[] args) {
		TreeNode node1 = DSUtil.getBinaryTree();
		TreeNode node2 = DSUtil.getBinaryTreeImage();
		
		boolean status = verifyIfBSTAreImage(node1, node2);
		System.out.println("BST Image verification Status = " + status);
	}

	private static boolean verifyIfBSTAreImage(TreeNode node1, TreeNode node2) {
		if(node1 == null && node2 == null)
			return true;
		
		if(node1 == null || node2 == null)
			return false;
		
		if(node1.value == node2.value){
			return (verifyIfBSTAreImage(node1.left, node2.right) && verifyIfBSTAreImage(node1.right, node2.left));
		}else
			return false;
	}
}