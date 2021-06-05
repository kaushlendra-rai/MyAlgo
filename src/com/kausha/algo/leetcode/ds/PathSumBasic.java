package com.kausha.algo.leetcode.ds;

// https://leetcode.com/problems/path-sum/
// Easy
public class PathSumBasic {
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

//		TreeNode b1 = new TreeNode(10);
//		TreeNode b2 = new TreeNode(5);
//		TreeNode b3 = new TreeNode(-3);
//		TreeNode b4 = new TreeNode(3);
//		TreeNode b5 = new TreeNode(2);
//		TreeNode b6 = new TreeNode(11);
//		TreeNode b7 = new TreeNode(3);
//		TreeNode b8 = new TreeNode(2);
//		TreeNode b9 = new TreeNode(1);
//		b1.left = b2;
//		b1.right = b3;
//		b2.left = b4;
//		b2.right = b5;
//		b3.right = b6;
//		b4.left = b7;
//		b4.right = b8;
//		b5.right = b9;		
		//TreeNode b1 = new TreeNode(7);
		
		TreeNode b1 = new TreeNode(7);
		TreeNode b2 = new TreeNode(3);
		b1.left = b2;

//		TreeNode b1 = new TreeNode(0);
//		TreeNode b2 = new TreeNode(1);
//		TreeNode b3 = new TreeNode(1);
//		b1.left = b2;
//		b1.right = b3;

		PathSumBasic ps = new PathSumBasic();
		System.out.println(ps.hasPathSum(b1, 10));
	}
	
	public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
        	return false;
        
		return hasPathSum(root, targetSum, 0);
    }
	
	private boolean hasPathSum(TreeNode root, int targetSum, int sum) {
		if(root == null)
			return false;
		if(root.left == null && root.right == null) {
			if(root.val + sum == targetSum)
				return true;
			else
				return false;
		}
		
		return hasPathSum(root.left, targetSum, sum+root.val) || hasPathSum(root.right, targetSum, sum+root.val);
	}
}
