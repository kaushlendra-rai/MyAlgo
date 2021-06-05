package com.kausha.algo.leetcode.ds;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BinaryTreeCamera {

	public static void main(String[] args) {
		BinaryTreeCamera bc = new BinaryTreeCamera();

//		TreeNode b1 = new TreeNode(10); // 2
//		TreeNode b2 = new TreeNode(5);
//		TreeNode b3 = new TreeNode(20);
//		TreeNode b4 = new TreeNode(15);
//		TreeNode b5 = new TreeNode(30);
//		b1.left = b2;
//		b1.right = b3;
//		b3.left = b4;
//		b3.right = b5;
		
//		TreeNode b1 = new TreeNode(10); // 2
//		TreeNode b2 = new TreeNode(5);
//		TreeNode b3 = new TreeNode(20);
//		TreeNode b4 = new TreeNode(15);
//		TreeNode b5 = new TreeNode(30);
//		b1.left = b2;
//		b2.left = b3;
//		b3.left = b4;
//		b4.right = b5;
		
		//TreeNode b1 = new TreeNode(10); // 2

		
		TreeNode b1 = new TreeNode(1);
		TreeNode b2 = new TreeNode(2);
		TreeNode b3 = new TreeNode(3);
		TreeNode b4 = new TreeNode(4);
		TreeNode b5 = new TreeNode(5);
		TreeNode b6 = new TreeNode(6);
		TreeNode b7 = new TreeNode(7);
		TreeNode b8 = new TreeNode(8);
		b1.left = b2;
		b1.right = b3;
		b2.left = b4;
		b4.left = b5;
		b4.right = b6;
		b3.left = b7;
		b3.right = b8;

		System.out.println(bc.minCameraCover(b1));
	}

	public int minCameraCover(TreeNode root) {
        int[] ans = solve(root);
        return Math.min(ans[1], ans[2]);
    }

    // 0: Strict ST; All nodes below this are covered, but not this one
    // 1: Normal ST; All nodes below and incl this are covered - no camera
    // 2: Placed camera; All nodes below this are covered, plus camera here
    public int[] solve(TreeNode node) {
        if (node == null)
            return new int[]{0, 0, 99999};

        int[] L = solve(node.left);
        int[] R = solve(node.right);
        int mL12 = Math.min(L[1], L[2]);
        int mR12 = Math.min(R[1], R[2]);

        int d0 = L[1] + R[1];
        int d1 = Math.min(L[2] + mR12, R[2] + mL12);
        int d2 = 1 + Math.min(L[0], mL12) + Math.min(R[0], mR12);
        return new int[]{d0, d1, d2};
    }
    
	// ################################################################
	int ans;
    Set<TreeNode> covered;
    public int minCameraCover_greedy(TreeNode root) {
        ans = 0;
        covered = new HashSet();
        covered.add(null);

        dfs(root, null);
        return ans;
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            dfs(node.left, node);
            dfs(node.right, node);

            if ((par == null && !covered.contains(node)) ||
                    !covered.contains(node.left) ||
                    !covered.contains(node.right)) {
                ans++;
                covered.add(node);
                covered.add(par);
                covered.add(node.left);
                covered.add(node.right);
            }
        }
    }
    
	public int minCameraCover_My_NotCorrect(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        boolean even = true;
        int evenCount = 0;
        int oddCount = 0;
        queue1.offer(root);
        
        while(!queue1.isEmpty()) {
        	TreeNode node = queue1.poll();
        	
        	if(even)
        		evenCount++;
        	else
        		oddCount++;
        	
        	if(node.left != null)
        		queue2.offer(node.left);
        	if(node.right != null)
        		queue2.offer(node.right);
        	
        	if(queue1.isEmpty()) {
        		even = !even;
        		
        		queue1 = queue2;
        		queue2 = new LinkedList<>();
        	}
        }
        
        if(oddCount == 0)
        	return 1;
        
		return evenCount < oddCount ? evenCount : oddCount;
    }
}
