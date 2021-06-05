package com.kausha.algo.leetcode.ds;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/recover-binary-search-tree/
/**
 * You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * @author sinkar
 *
 */
public class RecoverBST {

	public static void main(String[] args) {
		RecoverBST rb = new RecoverBST();

//		TreeNode b1 = new TreeNode(10);
//		TreeNode b2 = new TreeNode(5);
//		TreeNode b3 = new TreeNode(20);
//		TreeNode b4 = new TreeNode(15);
//		TreeNode b5 = new TreeNode(30);
//		b1.left = b2;
//		b1.right = b3;
//		b3.left = b4;
//		b3.right = b5;
		
//		TreeNode b1 = new TreeNode(20);
//		TreeNode b2 = new TreeNode(5);
//		TreeNode b3 = new TreeNode(10);
//		TreeNode b4 = new TreeNode(15);
//		TreeNode b5 = new TreeNode(30);
//		b1.left = b2;
//		b1.right = b3;
//		b3.left = b4;
//		b3.right = b5;
		
		TreeNode b1 = new TreeNode(3);
		TreeNode b2 = new TreeNode(1);
		TreeNode b3 = new TreeNode(4);
		TreeNode b4 = new TreeNode(2);
		b1.left = b2;
		b1.right = b3;
		b3.left = b4;
		
		rb.recoverTree(b1);
	}

	// To recover BST, we can make an in-order traversal and then find if all numbers are in ascending order.
	// Compare two adjascent numbers of ascending order. The first time nums[i-1] < nums[i], nums[i-1] is our first number
	// The second time it happens, nums[i] is our number.
	public void recoverTree(TreeNode root) {
        // Perform in-order traversal
		List<TreeNode> nums = new ArrayList<>();
		inorderTraversal(root, nums);
		System.out.println(nums);
		
		List<TreeNode> twoNums = findUnorderedNumbers(nums);
		System.out.println(twoNums);
		int tmp = twoNums.get(0).val;
		twoNums.get(0).val = twoNums.get(1).val;
		twoNums.get(1).val = tmp;
    }
	
	private List<TreeNode> findUnorderedNumbers(List<TreeNode> nums){
		List<TreeNode> twoNums = new ArrayList<>();
		boolean foundFirst = false;
		// The below is a workaround for case where two swapped numbers are neighbors.
		// Our below logic picks two numbers only if they are not neighbors, so if we find the first match,
		// We keep the neighbor as possible 2nd number if two are not found. 
		TreeNode temp = null;
		for(int i=1; i< nums.size(); i++) {
			if(!foundFirst && nums.get(i-1).val > nums.get(i).val) {
				twoNums.add(nums.get(i-1));
				foundFirst = true;
				temp = nums.get(i);
			}else if(foundFirst && nums.get(i-1).val > nums.get(i).val) {
				twoNums.add(nums.get(i));
				break;
			}
		}
		
		if(twoNums.size() == 1)
			twoNums.add(temp);
		return twoNums;
	}
	
	private void inorderTraversal(TreeNode root, List<TreeNode> nums) {
		if(root == null)
			return;
		
		inorderTraversal(root.left, nums);
		nums.add(root);
		inorderTraversal(root.right, nums);
	}
}
