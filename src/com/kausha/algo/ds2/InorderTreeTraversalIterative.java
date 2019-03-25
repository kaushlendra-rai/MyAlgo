package com.kausha.algo.ds2;

import java.util.Stack;

import com.kausha.algo.ds.DSUtil;
import com.kausha.algo.ds.TreeNode;

public class InorderTreeTraversalIterative {

	public static void main(String[] args) {
		TreeNode node = DSUtil.getBinaryTree();
		inOrderTraversalIterative(node);
	}

	private static void inOrderTraversalIterative(TreeNode root) {
		if(root== null){
			System.out.println("Node is empty");
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		
		while(!stack.isEmpty() || current != null){
			if(current != null){
				stack.push(current);
				current = current.left;
			}else{
				current  = stack.pop();
				System.out.println(current.value);
				current = current.right;
			}
		}
	}
}