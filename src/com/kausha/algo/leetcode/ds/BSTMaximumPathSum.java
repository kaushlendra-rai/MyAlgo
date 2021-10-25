package com.kausha.algo.leetcode.ds;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the 
 * sequence has an edge connecting them. A node can only appear in the sequence at most once.
 *  Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.


 * @author sinkar
 *
 */
public class BSTMaximumPathSum {

	public static void main(String[] args) {
//		TreeNode b1 = new TreeNode(-10); // Ans 42
//		TreeNode b2 = new TreeNode(9);
//		TreeNode b3 = new TreeNode(20);
//		TreeNode b4 = new TreeNode(15);
//		TreeNode b5 = new TreeNode(7);
//		b1.left = b2;
//		b1.right = b3;
//		b3.right = b4;
//		b3.left = b5;

//		TreeNode b1 = new TreeNode(-10); // Ans: 54
//		TreeNode b2 = new TreeNode(9);
//		TreeNode b3 = new TreeNode(20);
//		TreeNode b4 = new TreeNode(15);
//		TreeNode b5 = new TreeNode(7);
//		TreeNode b6 = new TreeNode(20);
//		
//		b1.left = b2;
//		b1.right = b3;
//		b3.right = b4;
//		b3.left = b5;
//		b2.left = b6;
		
//		TreeNode b1 = new TreeNode(1);  // Ans: 4
//		TreeNode b2 = new TreeNode(-2);
//		TreeNode b3 = new TreeNode(3);
//		
//		b1.left = b2;
//		b1.right = b3;
//		
		
//		TreeNode b1 = new TreeNode(7);
//		TreeNode b2 = new TreeNode(3);
//		TreeNode b3 = new TreeNode(3);
//		TreeNode b4 = new TreeNode(19);
//		b1.left = b2;
//		b1.right = b3;
//		b3.left = b4;
		
		//TreeNode b1 = new TreeNode(7);
//		
//		TreeNode b1 = new TreeNode(-20);
//		TreeNode b2 = new TreeNode(-30);
//		TreeNode b3 = new TreeNode(-40);
//		b1.left = b2;
//		b1.right = b3;
		
		TreeNode b1 = new TreeNode(9); // Ans: 54
		TreeNode b2 = new TreeNode(6);
		TreeNode b3 = new TreeNode(-3);
		TreeNode b4 = new TreeNode(2);
		TreeNode b5 = new TreeNode(-6);
		TreeNode b6 = new TreeNode(2);
		TreeNode b7 = new TreeNode(-6);
		TreeNode b8 = new TreeNode(-6);
		TreeNode b9 = new TreeNode(-6);
		
		b1.left = b2;
		b1.right = b3;
		b3.right = b4;
		b3.left = b5;
		b4.left = b6;
		b6.left = b7;
		b6.right = b8;
		b7.left = b9;

		
		BSTMaximumPathSum mps = new BSTMaximumPathSum();
		System.out.println(mps.maxPathSum(b1));
	}

	public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[] {root.val};
        maxPathSum(root, maxSum);
        
        return maxSum[0];
    }
	
	// We return the largest sum from node to left
	private int maxPathSum(TreeNode node, int[] maxSum) {
		if(node==null)
			return 0;
		
		int leftSum = maxPathSum(node.left, maxSum);
		int rightSum = maxPathSum(node.right, maxSum);
		int largerVal = rightSum > leftSum ? rightSum : leftSum;

		// There is a possibility that adding left or right value (typically when they are negative) decreases
		// the overall sum. In such cases we must not include that left/right for local sum.
		int localSum = 0;
		
		if(node.val > node.val + leftSum)
			localSum = node.val;
		else
			localSum = node.val + leftSum;

		if(localSum < localSum + rightSum)
			localSum += rightSum;
			
		if(localSum > maxSum[0])
			maxSum[0] = localSum;
		
		// add left/right to overall sum only if they end up increasing the sum.
        return largerVal+node.val > node.val ? largerVal+node.val : node.val;
    }
}
