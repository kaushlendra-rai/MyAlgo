package com.kausha.algo.leetcode.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
/**
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (i.e., from left to right, level by level from leaf to root).
 * @author sinkar
 *
 */
public class BSTLevelOrderTraversalBottomUP {

	public static void main(String[] args) {
		BSTLevelOrderTraversalBottomUP bu = new BSTLevelOrderTraversalBottomUP();

//		TreeNode b1 = new TreeNode(3);
//		TreeNode b2 = new TreeNode(9);
//		TreeNode b3 = new TreeNode(20);
//		TreeNode b4 = new TreeNode(7);
//		TreeNode b5 = new TreeNode(15);
//		b1.left = b2;
//		b1.right = b3;
//		b3.right = b4;
//		b3.left = b5;

		
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
//		b1.left = b2;
//		b1.right = b3;
//		b3.left = b4;
//		
		//TreeNode b1 = new TreeNode(7);
		
		TreeNode b1 = new TreeNode(7);
//		TreeNode b2 = new TreeNode(3);
//		b1.left = b2;

		
		System.out.println(bu.levelOrderBottom(b1));
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if(root == null)
			return new ArrayList<List<Integer>>();
		
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<TreeNode> children = new LinkedList<>();
		queue.offer(root);
		
		List<Integer> level = new ArrayList<>();
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			level.add(node.val);
			if(node.left != null)
				children.offer(node.left);
			if(node.right != null)
				children.offer(node.right);
			
			if(queue.isEmpty()) {
				stack.push(level);
				level = new ArrayList<>();
				
				queue = children;
				children = new LinkedList<>();
			}
		}
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		while(!stack.isEmpty()) {
			result.add(stack.pop());
		}
       return result;
    }
}
