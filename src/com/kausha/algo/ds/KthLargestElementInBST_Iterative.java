package com.kausha.algo.ds;

import java.util.Stack;

public class KthLargestElementInBST_Iterative {
	public static void main(String[] args) throws Exception{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		TreeNode root = BSTFromSortedArray.createBSTFromSortedArray(arr);
		
		TreeNode kthLargest = findKthLargest(root, 4);
		if(kthLargest == null){
			System.out.println("Element not found");
		}else
			System.out.println("KthLargest = " + kthLargest.value);
	}
	
	// Instead of normal left-node-right traversal, we do right-node-left traversal
	// to find the nth largest because largest would to to the right.
	private static TreeNode findKthLargest(TreeNode root, int i) {
		if(root == null)
			return null;
		
		// We go descending order and counting along side.
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(root != null) {
			stack.push(root);
			root = root.right;
		}
		int counter = 0;
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			counter++;
			if(counter == i)
				return temp;
			
			TreeNode node = temp.left;
			while(node != null) {
				stack.push(node);
				node = node.right;
			}
		}
		
		return null;
	}
}
