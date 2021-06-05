package com.kausha.algo.leetcode.ds;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class BinaryTreePostOrderTraversal {

	public static void main(String[] args) {
		BinaryTreePostOrderTraversal pot = new BinaryTreePostOrderTraversal();
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		System.out.println(pot.postorderTraversal(root));

	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> nums = new ArrayList<>();
		postOrder(root, nums);
	    return nums;    
    }

	void postOrder(TreeNode node, List<Integer> nums){
		if(node == null)
			return;
		
		postOrder(node.left, nums);
		postOrder(node.right, nums);
		
		nums.add(node.val);
	}
}
