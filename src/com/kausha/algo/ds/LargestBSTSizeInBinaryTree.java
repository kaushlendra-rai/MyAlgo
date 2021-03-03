package com.kausha.algo.ds;

// https://www.youtube.com/watch?v=4fiDs7CCxkc&list=RDCMUCZLJf_R2sWyUtXSKiKlyvAw&index=5
public class LargestBSTSizeInBinaryTree {

	public static void main(String[] args) {
		//TreeNode root = DSUtil.getBinaryTree();
		TreeNode root = new TreeNode(10);
		DSUtil.printTreeRecursively(root);
		System.out.println("\n");
		System.out.println("Size of largest BST: " + getSizeOfLargestBSTInBinaryTree(root));
	}
	
	public static int getSizeOfLargestBSTInBinaryTree(TreeNode root) {
		if(root == null)
			return 0;
		
		return (Integer)postOrderTraversal(root)[1];
	}

	private static Object[] postOrderTraversal(TreeNode node) {
		if(node == null)
			return null;
		
		Object[] status = new Object[4];
		
		Object[] left = postOrderTraversal(node.left);
		Object[] right = postOrderTraversal(node.right);
		
		if(left == null && right == null) {
			status[0] = true;
			status[1] = 1;
			status[2] = node.value;
			status[3] = node.value;
		}else if (left != null && right != null){
			if(node.value > (Integer)left[3] && node.value < (Integer)right[2] && (boolean)left[0] && (boolean)right[0]) {
				status[0] = true;
				status[1] = (Integer)left[1] + (Integer)right[1] + 1;
				status[2] = left[2];
				status[3] = right[3];
			}else {
				status[0] = false;
				status[1] = (Integer)left[1] > (Integer)right[1]? left[1] : right[1];
			}
		}else if(left != null) {
			if(node.value > (Integer)left[3] && (boolean)left[0]) {
				status[0] = true;
				status[1] = (Integer)left[1] + 1;
				status[2] = left[2];
				status[3] = node.value;
			}else {
				status[0] = false;
				status[1] = (Integer)left[1];
			}
		}else {
			if(node.value < (Integer)right[2] && (boolean)right[0]) {
				status[0] = true;
				status[1] = (Integer)right[1] + 1;
				status[2] = node.value;
				status[3] = right[3];
			}else {
				status[0] = false;
				status[1] = (Integer)right[1];
			}
		}
		
		return status;
	}
}
