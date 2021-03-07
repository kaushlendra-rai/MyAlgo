package com.kausha.algo.leetcode;

import com.kausha.algo.ds.DSUtil;
import com.kausha.algo.ds.TreeNode;

public class LowestCommonAncestorInBST {
	public static void main(String[] args) {
		TreeNode root = DSUtil.getBinaryTree();
		DSUtil.printTreeRecursively(root);
		System.out.println("\n");
		
		TreeNode lcaNode = getLowestCommonAncestorBST(root, 23, 32);
		
		System.out.println("LCA: " + lcaNode.value);
	}

	// Given that we are working with a BST, we capitalize on the BST property that 
	// all nodes to the left are smaller & right are larger.
	// We start at root. If one node is to the right and another to the left, the node is the common ancestor
	// else, move left or right.
	// ## Here we assume that the two values are indeed part of the BST.
	private static TreeNode getLowestCommonAncestorBST(TreeNode root, int left, int right) {
		if (root == null)
			return null;
		TreeNode lca = null;
		while(root != null) {
			if (root.value > left && root.value > right) {
				root = root.left;
			}else if (root.value < left && root.value < right)
				root = root.right;
			else {
				lca = root;
				break;
			}
		}
		
		return lca;
	}
}
