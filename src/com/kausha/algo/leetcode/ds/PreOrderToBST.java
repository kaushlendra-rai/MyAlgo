package com.kausha.algo.leetcode.ds;

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// https://www.youtube.com/watch?v=9sw8RRsBw6s
public class PreOrderToBST {
	public static void main(String[] args) {
		PreOrderToBST pob = new PreOrderToBST();
		
		int[] preorder = new int[] {8,5,1,7,10,12};
		
		TreeNode root = pob.bstFromPreorder(preorder);
		
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
	}

	// O(n)
	public TreeNode bstFromPreorder(int[] preorder) {
		return bstFromPreorder(preorder, new int[] {0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private TreeNode bstFromPreorder(int[] preorder, int[] idx, int min, int max) {
		TreeNode node = null;
		
		if(idx[0] < preorder.length && preorder[idx[0]] > min && preorder[idx[0]] < max) {
			node = new TreeNode(preorder[idx[0]]);
			if(idx[0]+1 < preorder.length && preorder[idx[0] +1] < preorder[idx[0]] && preorder[idx[0]+1] > min) {
				idx[0] = idx[0]+1;
				node.left = bstFromPreorder(preorder, idx, min, node.val);
			}
			
			if(idx[0]+1 < preorder.length && preorder[idx[0] +1] > node.val && preorder[idx[0]+1] < max) {
				idx[0] = idx[0]+1;
				node.right = bstFromPreorder(preorder, idx, node.val, max);
			}
		}
		
		return node; 
	}

	// Basic O(nlogn) and worst O(n^2) for skewed BST
	public TreeNode bstFromPreorder_Slow(int[] preorder) {
		
		TreeNode root = null;
		
		for(int i=0; i < preorder.length; i++)
			root = bstFromPreorder(preorder[i], root);
		
        return root;
    }

	private TreeNode bstFromPreorder(int num, TreeNode root) {
		if(root == null)
			return new TreeNode(num);
		
		if(num < root.val) {
			root.left = bstFromPreorder(num, root.left);
		}else
			root.right = bstFromPreorder(num, root.right);
		
		return root;
	}
}
