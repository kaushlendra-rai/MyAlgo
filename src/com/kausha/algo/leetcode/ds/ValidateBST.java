package com.kausha.algo.leetcode.ds;

public class ValidateBST {

	public static void main(String[] args) {

//		TreeNode b1 = new TreeNode(7);
//		TreeNode b2 = new TreeNode(3);
//		TreeNode b3 = new TreeNode(9);
//		TreeNode b4 = new TreeNode(1);
//		b1.left = b2;
//		b1.right = b3;
//		b3.right = b4;
//		
//		TreeNode b1 = new TreeNode(5);
//		TreeNode b2 = new TreeNode(1);
//		TreeNode b3 = new TreeNode(4);
//		TreeNode b4 = new TreeNode(6);
//		TreeNode b5 = new TreeNode(3);
//		b1.left = b2;
//		b1.right = b3;
//		b3.right = b4;
//		b3.left = b5;
//		
//		TreeNode b1 = new TreeNode(5);
//		TreeNode b2 = new TreeNode(1);
//		TreeNode b3 = new TreeNode(14);
//		TreeNode b4 = new TreeNode(16);
//		TreeNode b5 = new TreeNode(13);
//		b1.left = b2;
//		b1.right = b3;
//		b3.right = b4;
//		b3.left = b5;
//		
		TreeNode b1 = new TreeNode(Integer.MAX_VALUE);
		//TreeNode b2 = new TreeNode(5);
		//b1.left = b2;
		
//		TreeNode b1 = new TreeNode(2);
//		TreeNode b2 = new TreeNode(1);
//		TreeNode b3 = new TreeNode(3);
//		b1.left = b2;
//		b1.right = b3;
//		
		
//		TreeNode b1 = new TreeNode(Integer.MAX_VALUE);
		
		
		ValidateBST vb = new ValidateBST();
		
		System.out.println(vb.isValidBST(b1));
	}

	public boolean isValidBST(TreeNode root) {
		if(root == null)
			return false;
		
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
	
	private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
		if(root == null)
			return true;
		if(root.val <= minValue || root.val >= maxValue)
			return false;
		
			
		return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
	}

	public boolean isValidBST_old(TreeNode root) {
		if(root == null)
			return false;
		
		Object[] status = traverseBST_old(root);
        return (boolean)status[0];
    }
	
	private Object[] traverseBST_old(TreeNode node) {
		if(node.left == null && node.right == null) {
			return new Object[] {true, node.val, node.val};
		}
		
		Object[] left = null;
		if(node.left != null)
			left = traverseBST_old(node.left);
		else
			left = new Object[] {true, node.val, node.val};
			
		Object[] right = null;
		if(node.right != null)
			right = traverseBST_old(node.right);
		else
			right = new Object[] {true, node.val, node.val};
		
		if(!(boolean)left[0] || !(boolean)right[0] )
			return new Object[] {false};
System.out.printf("%d, %d, %d\n", (int)left[2], node.val, (int)right[1]);
		if((int)left[2] >= node.val || (int)right[1] <= node.val)
			return new Object[] {false};
		
		return new Object[] {true, left[2], right[1]}; 
	}
}
