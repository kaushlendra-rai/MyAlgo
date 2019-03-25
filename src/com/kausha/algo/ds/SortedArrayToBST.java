package com.kausha.algo.ds;

public class SortedArrayToBST {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		TreeNode bst = sortedArrayToBST(arr, 0, arr.length-1);
		DSUtil.printTree(bst);
		
	}

	private static TreeNode sortedArrayToBST(int[] arr, int start, int end) {
		if(arr == null || arr.length == 0 || start>end)
			return null;
		
		int mid = start + (end-start)/2;
		
		TreeNode node = new TreeNode(arr[mid]);
		
		TreeNode left = sortedArrayToBST(arr, start, mid-1);
		TreeNode right = sortedArrayToBST(arr, mid + 1, end);
		
		node.left = left;
		node.right = right;
		
		return node;
	}
}