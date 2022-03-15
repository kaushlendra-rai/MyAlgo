package com.kausha.algo.ds;

import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=2VZHLtHM_6w
public class BSTFindAllAncestorsOfNode {

	public static void main(String[] args) {
		TreeNode root = DSUtil.getBinaryTree();
		DSUtil.printTree(root);
		//List<TreeNode> nodeList = getAncestors(root, new TreeNode(23));
		List<TreeNode> nodeList = getAncestors(root, new TreeNode(26));
		System.out.println("Output::");
		for(TreeNode node : nodeList)
			System.out.println(node.value);
	}

	// Do an post-order traversal and maintain a Stack of nodes visited.
	// Pop if no match found and returning from the node.
	public static List<TreeNode> getAncestors(TreeNode root, TreeNode node){
		List<TreeNode> nodeList = new ArrayList<>();
		findAncestors(root, node, nodeList);
		return nodeList;
	}
	
	private static boolean findAncestors(TreeNode root, TreeNode node, List<TreeNode> nodeList) {
		if(root== null)
			return false;
		
		if(root.getValue() == node.getValue()) {
			return true;
		}
		
		boolean matchFound = findAncestors(root.left, node, nodeList) || findAncestors(root.right, node, nodeList);
		if(matchFound)
			nodeList.add(root);
		return matchFound;
	}
}
