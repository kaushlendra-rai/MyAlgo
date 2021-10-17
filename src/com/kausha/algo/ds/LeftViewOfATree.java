package com.kausha.algo.ds;

import java.util.LinkedList;
import java.util.Queue;


public class LeftViewOfATree {
	public static void main(String[] args) {
		TreeNode root = DSUtil.getBinaryTree();
		DSUtil.printTreeRecursively(root);
		System.out.println();
		printLeftViewOfTheTree(root);
		System.out.println();
		printLeftViewOfTheTree_new(root);
	}

	// Here we use 'null' as a level order traversal delimiter.
		private static void printLeftViewOfTheTree_new(TreeNode root) {
			if(root == null)
				return;
			
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			queue.offer(null);
			
			while(!queue.isEmpty()) {
				TreeNode node = queue.poll();
				
				if( node != null && node.right != null)
					queue.offer(node.right);
				if(node != null && node.left != null)
					queue.offer(node.left);
				
				if(!queue.isEmpty() && queue.peek() == null) {
					queue.poll(); // Poll the line delimiter 'null';
					System.out.print(node.value + " ");
					queue.offer(null);
				}
			}
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
				System.out.print(node.value + " ");
				queue.addAll(childQueue);
				childQueue.clear();
			}
		}
	}
}
