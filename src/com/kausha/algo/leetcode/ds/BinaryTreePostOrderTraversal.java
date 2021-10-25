package com.kausha.algo.leetcode.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
		System.out.println("Recursive Approach: " + pot.postorderTraversal(root));
		
		System.out.println("Itr approach: " + pot.postorderTraversal_itr(root));

	}
	public List<Integer> postorderTraversal_itr(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		List<Integer> result = new ArrayList<Integer>();
		
		stack1.push(root);
		
		while(!stack1.isEmpty()) {
			TreeNode node = stack1.pop();
			stack2.push(node);
			if(node.left != null)
				stack1.push(node.left);
			if(node.right != null)
				stack1.push(node.right);
		}
		
		while(!stack2.isEmpty())
			result.add(stack2.pop().val);
			
		return result;
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
