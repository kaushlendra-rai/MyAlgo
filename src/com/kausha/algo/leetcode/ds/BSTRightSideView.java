package com.kausha.algo.leetcode.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-right-side-view/
//Given the root of a binary tree, imagine yourself standing on the right side of it, 
// return the values of the nodes you can see ordered from top to bottom.
public class BSTRightSideView {

	public static void main(String[] args) {
		BSTRightSideView brv = new BSTRightSideView();
		
//		TreeNode b1 = new TreeNode(-10); // Ans [-10, 20, 15, 3]
//		TreeNode b2 = new TreeNode(9);
//		TreeNode b3 = new TreeNode(20);
//		TreeNode b4 = new TreeNode(15);
//		TreeNode b5 = new TreeNode(7);
//		TreeNode b6 = new TreeNode(5);
//		TreeNode b7 = new TreeNode(3);
//		b1.left = b2;
//		b1.right = b3;
//		b3.right = b4;
//		b3.left = b5;
//		b2.left = b6;
//		b6.left = b7;

		TreeNode b1 = new TreeNode(-10); // Ans -10
		System.out.println(brv.rightSideView(b1));
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> rightView = new ArrayList<>();
		if(root == null)
			return rightView;
		
		Queue<TreeNode> que = new LinkedList<>();
		Queue<TreeNode> child = new LinkedList<>();
		que.offer(root); 

		while(!que.isEmpty()) {
			TreeNode node = que.poll();
			
			if(node.left != null)
				child.offer(node.left);
			
			if(node.right != null)
				child.offer(node.right);
			
			if(que.isEmpty()) {
				rightView.add(node.val);
				que = child;
				child = new LinkedList<>();
			}
		}
		
        return rightView;
    }
}
