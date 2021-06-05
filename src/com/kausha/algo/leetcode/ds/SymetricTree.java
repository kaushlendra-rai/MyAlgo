package com.kausha.algo.leetcode.ds;

// https://leetcode.com/problems/symmetric-tree/
public class SymetricTree {

	public static void main(String[] args) {
//		TreeNode b1 = new TreeNode(7);
//		TreeNode b2 = new TreeNode(3);
//		TreeNode b3 = new TreeNode(3);
//		TreeNode b4 = new TreeNode(19);
//		TreeNode b5 = new TreeNode(19);
//		b1.left = b2;
//		b1.right = b3;
//		b3.right = b4;
//		b2.left = b5;

//		TreeNode b1 = new TreeNode(7);
//		TreeNode b2 = new TreeNode(3);
//		TreeNode b3 = new TreeNode(3);
//		TreeNode b4 = new TreeNode(19);
//		TreeNode b5 = new TreeNode(19);
//		b1.left = b2;
//		b1.right = b3;
//		b3.left = b4;
//		b2.left = b5;
		
		//TreeNode b1 = new TreeNode(7);
		
		TreeNode b1 = new TreeNode(7);
		TreeNode b2 = new TreeNode(3);
		b1.left = b2;
		
		SymetricTree st = new SymetricTree();
		System.out.println(st.isSymmetric(b1));
	}

	public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }
	
	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left == null && right == null)
			return true;
		if(left == null || right == null)
			return false;
		
		return left.val == right.val && isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }
}
