package com.kausha.algo.ds;

public class KthLargestElementInBST_Recursive {
	public static void main(String[] args) throws Exception{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		TreeNode root = BSTFromSortedArray.createBSTFromSortedArray(arr);
		
		TreeNode kthLargest = findKthLargest(root, 4);
		if(kthLargest == null){
			System.out.println("Element not found");
		}else
			System.out.println("KthLargest = " + kthLargest.value);
	}

	private static TreeNode findKthLargest(TreeNode node, int i) {
		if(node == null || i <= 0)
			return null;
		
		Object[] index = new Object[2];
		index[0] = 0;
		
		findKthLargest(node, i, index);
		return (TreeNode)index[1];
	}

	private static void findKthLargest(TreeNode node, int i, Object[] index) {
		if(node == null)
			return;
		
		findKthLargest(node.right, i, index);
		index[0] = (Integer)index[0] + 1;
		
		if(i == (Integer)index[0]){
			index[1] = node;
			return;
		}
		
		findKthLargest(node.left, i, index);
	}
}