package com.kausha.algo.gfg.microsoft;

import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/root-to-leaf-paths-sum/1/?company[]=Microsoft&company[]=Microsoft&page=1&query=company[]Microsoftpage1company[]Microsoft

public class BTRootToLeafPathSum {

	public static void main(String[] args) {

		Node root = new Node(10);
		Node node1 = new Node(20);
		Node node2 = new Node(30);
		Node node3 = new Node(40);
		Node node4 = new Node(60);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		
		System.out.println(BTRootToLeafPathSum.treePathsSum(root));
	}

	public static long treePathsSum(Node root)
    {
		long sum = 0;
		List<Long> nums = new ArrayList<>();
		treePathsSum(root, 0, nums);
		for(Long num : nums)
			sum += num;
		return sum;
    }
	
	public static void treePathsSum(Node root, long currentSum, List<Long> nums) {
		currentSum = currentSum * 10 + root.data;
		if(root.left == null && root.right == null) {
			nums.add(currentSum);
			return;
		}
		
		if(root.left != null)
			treePathsSum(root.left, currentSum, nums);

		if(root.right != null)
			treePathsSum(root.right, currentSum, nums);
	}
}
