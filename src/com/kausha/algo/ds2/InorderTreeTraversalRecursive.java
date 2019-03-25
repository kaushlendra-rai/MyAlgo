package com.kausha.algo.ds2;

import com.kausha.algo.ds.DSUtil;
import com.kausha.algo.ds.TreeNode;

public class InorderTreeTraversalRecursive {

	public static void main(String[] args) {
		TreeNode node = DSUtil.getBinaryTree();
		inOrderTraversalRecursive(node);
	}

	private static void inOrderTraversalRecursive(TreeNode node) {
		if(node!= null){
			inOrderTraversalRecursive(node.left);
			System.out.println(node.value);
			inOrderTraversalRecursive(node.right);
		}
	}
}