package com.kausha.algo.leetcode.ds;

// https://leetcode.com/problems/same-tree/
/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 * @author sinkar
 *
 */
public class SameTree {

	public static void main(String[] args) {
		TreeNode b1 = new TreeNode(7);
		TreeNode b2 = new TreeNode(3);
		TreeNode b3 = new TreeNode(9);
		TreeNode b4 = new TreeNode(19);
		b1.left = b2;
		b1.right = b3;
		b3.right = b4;
		
		TreeNode n1 = new TreeNode(7);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(9);
		TreeNode n4 = new TreeNode(19);
		n1.left = n2;
		n1.right = n3;
		//n3.right = n4;
		
		SameTree st = new SameTree();
		System.out.println(st.isSameTree(b1, n1));
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p== null && q==null)
			return true;
		if(p== null || q==null)
			return false;
		
		if(p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		
		return false;
    }
}

class TreeNode {
	 @Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}
	int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }