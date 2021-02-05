package com.kausha.algo.ds;

import java.util.LinkedList;
import java.util.Queue;

import com.sun.org.apache.xerces.internal.dom.ChildNode;


public class LeftViewOfATree {
	public static void main(String[] args) {
		TreeNode root = DSUtil.getBinaryTree();
		DSUtil.printTreeRecursively(root);
		printLeftViewOfTheTree(root);
	}

	/**
	 * We keep current and child nodes in Queues and add child nodes from right to left.
	 * With this approach, we print the node if it is the last node in the queue.
	 * This prints only the first left view and ignores the rest of the nodes/left-vies beyond the first view.
	 * @param root
	 */
	private static void printLeftViewOfTheTree(TreeNode root) {
		if(root == null)
			return;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<TreeNode> childQueue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			
			if(node.right != null)
				childQueue.offer(node.right);
			if(node.left != null)
				childQueue.offer(node.left);

			if(queue.isEmpty()) {
				System.out.println(node.value);
				queue.addAll(childQueue);
				childQueue.clear();
			}
		}
	}
}
