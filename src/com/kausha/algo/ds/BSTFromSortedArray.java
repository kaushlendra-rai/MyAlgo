package com.kausha.algo.ds;

public class BSTFromSortedArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		TreeNode root = createBSTFromSortedArray(arr);
		DSUtil.printTree(root);
	}
	
	public static TreeNode createBSTFromSortedArray(int[] arr){
		if(arr == null)
			return null;
		
		return createBSTFromSortedArray(arr, 0, arr.length-1);
	}

	private static TreeNode createBSTFromSortedArray(int[] arr, int start, int end) {	
		if(start>end)
			return null;
		
		int mid = start + (end-start)/2;
		TreeNode left = createBSTFromSortedArray(arr, start, mid-1);
		TreeNode right = createBSTFromSortedArray(arr, mid + 1, end);
		
		TreeNode node = new TreeNode(arr[mid]);
		node.left = left;
		node.right = right;
		
		return node;
	}
}