package com.kausha.algo.leetcode.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/
public class BSTZigZagOrderTraversal {
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

		TreeNode b1 = new TreeNode(3);
		TreeNode b2 = new TreeNode(9);
		TreeNode b3 = new TreeNode(20);
		TreeNode b4 = new TreeNode(15);
		TreeNode b5 = new TreeNode(7);
		b1.left = b2;
		b1.right = b3;
		b3.left = b4;
		b3.right = b5;
		
		//TreeNode b1 = new TreeNode(7);
		
//		TreeNode b1 = new TreeNode(7);
//		TreeNode b2 = new TreeNode(3);
//		b1.left = b2;
		
		BSTZigZagOrderTraversal zz = new BSTZigZagOrderTraversal();
		System.out.println(zz.zigzagLevelOrder(b1));
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> lotList = new ArrayList<>();
        if(root == null)
        	return lotList;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        Queue<TreeNode> child = new LinkedList<>();
        List<Integer> levelNums = new ArrayList<>();
        // We reverse the number list if it is odd.
        boolean even = true;
        while(!queue.isEmpty()) {
        	TreeNode node = queue.poll();
        	levelNums.add(node.val);
        	if(node.left != null)
        		child.offer(node.left);
        	if(node.right != null)
        		child.offer(node.right);
        	
        	if(queue.isEmpty()) {
        		// For runtime improvement, we can simply replace child for queue and create a new Child Queue.
        		queue = child;
        		child = new LinkedList<>();
        		// Need to check if can can maintain the reversal order at the time of parsing the tree itself rather than
        		// Explicitly reversing it later.
        		if(!even) {
        			Collections.reverse(levelNums);
        			even = true;
        		}else
        			even = false;
        		
        		lotList.add(levelNums);
        		levelNums = new ArrayList<>();
        	}
        }
        
		return lotList;
    }
	
}
