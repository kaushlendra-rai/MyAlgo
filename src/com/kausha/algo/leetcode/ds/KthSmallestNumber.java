package com.kausha.algo.leetcode.ds;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestNumber {

	public static void main(String[] args) {
		KthSmallestNumber ks = new KthSmallestNumber();
//		TreeNode b1 = new TreeNode(7);
//		TreeNode b2 = new TreeNode(3);
//		TreeNode b3 = new TreeNode(9);
//		TreeNode b4 = new TreeNode(11);
//		b1.left = b2;
//		b1.right = b3;
//		b3.right = b4;
		
		TreeNode b1 = new TreeNode(5);
		TreeNode b2 = new TreeNode(3);
		TreeNode b3 = new TreeNode(6);
		TreeNode b4 = new TreeNode(2);
		TreeNode b5 = new TreeNode(4);
		TreeNode b6 = new TreeNode(1);
		b1.left = b2;
		b1.right = b3;
		b2.right = b5;
		b2.left = b4;
		b4.left = b6;
		
		System.out.println(ks.kthSmallest(b1, 1));
	}

	public int kthSmallest(TreeNode root, int k) {
		Object[] value = new Object[2];
		value[0] = 1;
		kthSmallest(root, k, value);
        return (int)value[1];
    }
	
	private void kthSmallest(TreeNode node, int k, Object[] value) {
		if(node == null)
			return;
		
		kthSmallest(node.left, k, value);
		// Short-circuit any further traversal if a match is found
		if((int)value[0] == -1)
			return;
		
		if((int)value[0] == k) {
			value[0] = -1;
			value[1] = node.val;
			return;
		}
		
		value[0] = 1 + (int)value[0];
		
		kthSmallest(node.right, k, value);
    }
}
