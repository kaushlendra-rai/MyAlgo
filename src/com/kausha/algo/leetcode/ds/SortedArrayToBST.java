package com.kausha.algo.leetcode.ds;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
// Easy
public class SortedArrayToBST {

	public static void main(String[] args) {
		SortedArrayToBST sab = new SortedArrayToBST();

//		int[] nums = new int[] {-10, -3, 0, 5, 9};
//		TreeNode node = sab.sortedArrayToBST(nums);
//		System.out.println(node.val);
//		System.out.println(node.left.val);
//		System.out.println(node.right.val);
//		System.out.println(node.left.right.val);
//		System.out.println(node.right.right.val);
		
		int[] nums = new int[] {1, 2};
		TreeNode node = sab.sortedArrayToBST(nums);
		System.out.println(node.val);
		System.out.println(node.right.val);
		
	}

	public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
	
	private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		if(start>end)
			return null;
		
		int mid = start + (end-start)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = sortedArrayToBST(nums, start, mid-1);
		node.right = sortedArrayToBST(nums, mid+1, end);
		
        return node;
    }
}
