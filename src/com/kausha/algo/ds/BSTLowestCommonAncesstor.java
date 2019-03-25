package com.kausha.algo.ds;



public class BSTLowestCommonAncesstor {
	public static void main(String[] args) {
		TreeNode node = DSUtil.getBinaryTree();
		TreeNode node1 = new TreeNode(52); // Could also be tested with same line node '22'.
		TreeNode node2 = new TreeNode(24);
		TreeNode result = findNodeWithCommonAncestor2(node, null, node1, node2);
	}

	private static TreeNode findNodeWithCommonAncestor(TreeNode node, TreeNode parent, TreeNode node1, TreeNode node2) {
		if(node == null)
			return null;
		
		TreeNode match = null;
		if(node1.equals(node) || node2.equals(node))
			match = node;
		
		TreeNode left = findNodeWithCommonAncestor(node.left, node, node1, node2);
		TreeNode right = findNodeWithCommonAncestor(node.right, node, node1, node2);
		
		if((node1.equals(left) || node2.equals(left)) && (node1.equals(right) || node2.equals(right))){
			// Match Found. Parent is the Ancestor
			System.out.println(node.value);
		}else if(match != null && (node1.equals(left) || node2.equals(left) || node1.equals(right) || node2.equals(right))){
			// Match found in Same line of of tree.
			if(parent != null)
				System.out.println(parent.value);
			else
				System.out.println("Match at Root");
		}else if(node1.equals(left) || node2.equals(left))
			return left;
		else if(node1.equals(right) || node2.equals(right))
			return right;
		
		return match;
	}
	
	private static TreeNode findNodeWithCommonAncestor2(TreeNode node, TreeNode parent, TreeNode node1, TreeNode node2) {
		if(node == null)
			return null;
		
		TreeNode match = null;
		if(node1.equals(node) || node2.equals(node))
			match = node;
		
		TreeNode left = findNodeWithCommonAncestor2(node.left, node, node1, node2);
		TreeNode right = findNodeWithCommonAncestor2(node.right, node, node1, node2);
		
		if((node1.equals(left) || node2.equals(left)) && (node1.equals(right) || node2.equals(right))){
			// Match Found. Parent is the Ancestor
			System.out.println(node.value);
		}else if(match != null && (node1.equals(left) || node2.equals(left) || node1.equals(right) || node2.equals(right))){
			// Match found in Same line of of tree.
			if(parent != null)
				System.out.println(parent.value);
			else
				System.out.println("Match Found at Root");
		}else if(node1.equals(left) || node2.equals(left))
			return left;
		else if(node1.equals(right) || node2.equals(right))
			return right;
		
		return match;
	}
}