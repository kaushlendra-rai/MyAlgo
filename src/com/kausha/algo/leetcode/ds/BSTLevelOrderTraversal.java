package com.kausha.algo.leetcode.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTLevelOrderTraversal {

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

		TreeNode b1 = new TreeNode(7);
		TreeNode b2 = new TreeNode(3);
		TreeNode b3 = new TreeNode(3);
		TreeNode b4 = new TreeNode(19);
		b1.left = b2;
		b1.right = b3;
		b3.left = b4;
		
		//TreeNode b1 = new TreeNode(7);
		
//		TreeNode b1 = new TreeNode(7);
//		TreeNode b2 = new TreeNode(3);
//		b1.left = b2;
		
		BSTLevelOrderTraversal lot = new BSTLevelOrderTraversal();
		System.out.println(lot.levelOrder(b1));
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lotList = new ArrayList<>();
        if(root == null)
        	return lotList;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        Queue<TreeNode> child = new LinkedList<TreeNode>();
        List<Integer> levelNums = new ArrayList<>();
        while(!queue.isEmpty()) {
        	TreeNode node = queue.poll();
        	levelNums.add(node.val);
        	if(node.left != null)
        		child.offer(node.left);
        	if(node.right != null)
        		child.offer(node.right);
        	
        	if(queue.isEmpty()) {
        		// For runtime improvement, we can simply replace child for queue and create a new Child Queue.
        		queue.addAll(child);
        		child.clear();
        		lotList.add(levelNums);
        		levelNums = new ArrayList<>();
        	}
        }
        
		return lotList;
    }
}
