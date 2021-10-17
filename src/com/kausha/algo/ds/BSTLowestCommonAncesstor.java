package com.kausha.algo.ds;

public class BSTLowestCommonAncesstor {
	public static void main(String[] args) {
		TreeNode node = DSUtil.getBinaryTree();
		TreeNode node1 = new TreeNode(52); // Could also be tested with same line node '22'.
		TreeNode node2 = new TreeNode(24);
		TreeNode[] ancester = new TreeNode[1];
		TreeNode result = findNodeWithCommonAncestor(node, null, node1, node2, ancester);
		if(ancester[0] != null)
			System.out.println("ancestor: " + ancester[0].value);
		else
			System.out.println("ancestor is null");
	}

	private static TreeNode findNodeWithCommonAncestor(TreeNode node, TreeNode parent, TreeNode node1, TreeNode node2, TreeNode[] ancester) {
		if(node == null)
			return null;
		// If match found, not need to process any further.
		if(ancester[0] != null)
			return null;
		
		TreeNode left = findNodeWithCommonAncestor(node.left, node, node1, node2, ancester);
		TreeNode right = findNodeWithCommonAncestor(node.right, node, node1, node2, ancester);
		
		if(left != null && right != null && (left.value == node1.value || right.value == node1.value) && (left.value == node2.value || right.value == node2.value)){
			ancester[0] = node;
			return null;
		}else if((left != null && (left.value == node1.value || left.value == node2.value)) || (right != null && (right.value == node1.value || right.value == node2.value)) &&
				(node.value == node1.value || node.value == node2.value)) {
			ancester[0] = parent;
			return null;
		}else if(node.value == node1.value || node.value == node2.value)
			return node;
		else if (left != null)
			return left;
		else if(right != null)
			return right;
		
		return null;
	}
}