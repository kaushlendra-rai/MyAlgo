package com.kausha.algo.leetcode.ds;

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
