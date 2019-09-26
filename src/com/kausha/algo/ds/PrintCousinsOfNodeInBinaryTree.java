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
	// For every null we encounter, we put 'nil' string in the queue
	// And check if the current node value matches the number.
	// If yes, print number pair (0, 1), (2, 3), (4, 5), etc. except for the pair in which the match occurred.
	// Skip printing 'nil'.
	// We used 'nil' to ensure that we can group elements with same parent together and avoid printing them as cousins.
	private static void printCousinNodes(TreeNode root, TreeNode searchNode) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<TreeNode> childQueue = new LinkedList<TreeNode>();

		queue.offer(root);
		boolean matchFound = false;
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			
			if(node != null) {
				childQueue.offer(node.left);
				childQueue.offer(node.right);
			
				if((node.left != null && node.left.value == searchNode.value) || (node.right != null && node.right.value == searchNode.value)) {
					matchFound = true;
					System.out.println("***** Match Found");
				}
				// Breadth parsing ended.
				if(queue.isEmpty()) {
					
					// print siblings if match found from childQueue
					if(matchFound) {
						while(!childQueue.isEmpty()) {
							TreeNode match1 = childQueue.poll();
							TreeNode match2 = childQueue.poll();
							if(!((match1 != null && match1.value == searchNode.value) ||  (match2 != null && match2.value == searchNode.value))){
								if(match1 != null)
								System.out.println(match1.value);
								
								if(match2 != null)
									System.out.println(match2.value);
							}
						}
						return;
					}
					
					queue = childQueue;
					childQueue = new LinkedList<TreeNode>();
				}
			}
		}
	}
}
