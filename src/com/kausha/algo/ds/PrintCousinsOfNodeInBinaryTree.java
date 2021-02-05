package com.kausha.algo.ds;

import java.util.LinkedList;
import java.util.Queue;

// Question: https://www.geeksforgeeks.org/print-cousins-of-a-given-node-in-binary-tree/
public class PrintCousinsOfNodeInBinaryTree {
	public static void main(String[] args) {
		TreeNode root = DSUtil.getBinaryTree();
		DSUtil.printTreeRecursively(root);
		System.out.println("\n");
		TreeNode node = new TreeNode(24);
		printCousinNodes(root, node);
	}

	// The idea here I have is that we do a breath level traversal
	// And check if the current node value matches the number.
	// If yes, print number pair (0, 1), (2, 3), (4, 5), etc. except for the pair in which the match occurred.
	// If a match is found in left/right child of the node,, we skip adding both of them to the queue.
	private static void printCousinNodes(TreeNode root, TreeNode searchNode) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<TreeNode> childQueue = new LinkedList<TreeNode>();

		queue.offer(root);
		boolean matchFound = false;
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			
			if(node != null) {
				if((node.left != null && node.left.value == searchNode.value) || (node.right != null && node.right.value == searchNode.value)) {
					matchFound = true;
					System.out.println("***** Match Found");
				}else {
					if(node.left != null)
						childQueue.offer(node.left);
					if(node.right != null)
						childQueue.offer(node.right);
				}
				// Breadth parsing ended.
				if(queue.isEmpty()) {					
					// print siblings if match found from childQueue
					if(matchFound) {
						while(!childQueue.isEmpty()) 
							System.out.println(childQueue.poll().value);

						return;
					}
					
					queue = childQueue;
					childQueue = new LinkedList<TreeNode>();
				}
			}
		}
	}
}
