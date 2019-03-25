package com.kausha.algo.ds;

public class BSTLowestCommonAncesstor_old {

	public static void main(String[] args) {
		TreeNode node = DSUtil.getBinaryTree();
		TreeNode node1 = new TreeNode(52);
		TreeNode node2 = new TreeNode(24);
		TreeNode result = findNodeWithCommonAncestor(node, node1, node2);
	}

	private static TreeNode findNodeWithCommonAncestor(TreeNode node, TreeNode node1, TreeNode node2) {
		if(node == null)
			return null;
		
		TreeNode leftMatch = findNodeWithCommonAncestor(node.left, node1, node2);
		TreeNode rightMatch = findNodeWithCommonAncestor(node.right, node1, node2);
		int matchCount = 1;
		
		if(leftMatch != null && (leftMatch.value == node1.value || leftMatch.value == node2.value)){
			matchCount *= 2;
		}
		
		if(rightMatch != null && (rightMatch.value == node1.value || rightMatch.value == node2.value)){
			matchCount *=3;
		}
		
		if(node != null && (node.value == node1.value || node.value == node2.value)){
			matchCount *= 5;
		}

		if(matchCount >= 6){
			System.out.println("Matching node = " + node.value);
			return node;
		}else if(matchCount == 2)
			return leftMatch;
		else if(matchCount == 3)
			return rightMatch;
		else if(matchCount == 5)
			return node;
		
		return null;
	}
}