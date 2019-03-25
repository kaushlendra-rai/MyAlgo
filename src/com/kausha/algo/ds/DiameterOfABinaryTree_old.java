package com.kausha.algo.ds;

public class DiameterOfABinaryTree_old {

	public static void main(String[] args) {
		TreeNode root = DSUtil.getBinaryTree2();
		Object[] diameterInfo = findTreeDepth(root);
		
		System.out.println("Depth of Tree = " + diameterInfo[0]);
		System.out.println("Tree Diameter = " + diameterInfo[1]);
		System.out.println("Tree Diameter End-points= " + ((TreeNode)diameterInfo[2]).value + "  ,  " + ((TreeNode)diameterInfo[3]).value);
	}
	
	private static Object[] findTreeDepth(TreeNode node){
		if(node == null)
			return null;
		
		Object[] diameterInfo = new Object[4];
		diameterInfo[1] = 0;
		findTreeDepth(node, diameterInfo);
		
		return diameterInfo;
	}

	private static void findTreeDepth(TreeNode node, Object[] diameterInfo) {
		if(node == null){
			diameterInfo[0] = 0;
			diameterInfo[1] = 0;
			diameterInfo[2] = null;
			diameterInfo[3] = null;
			return;
		}
		
		// Parse left node
		findTreeDepth(node.left, diameterInfo);
		int leftDepth = (Integer)diameterInfo[0];
		TreeNode leftRNode = (TreeNode) diameterInfo[3];

		// Parse right node
		findTreeDepth(node.right, diameterInfo);
		int rightDepth = (Integer) diameterInfo[0];
		TreeNode rightRNode = (TreeNode) diameterInfo[3];
		
		if(leftDepth + rightDepth + 1 > (Integer)diameterInfo[1]){
			// If there is no left child, current node is the left most node
			if(leftDepth == 0)
				leftRNode = node;
			
			// If there is no right child, current node is the right most node
			if(rightDepth == 0)
				rightRNode = node;
			
			// A code here we follow is that after every parsing, the diameterInfo[2] holds node with smaller 
			// depth and diameterInfo[3] holds node with larger depth.
			// When we merge the left & right node, we consider only the node at index '3' for both lists.
			if(leftDepth < rightDepth){
				diameterInfo[2] = leftRNode;
				diameterInfo[3] = rightRNode;
			}else{
				diameterInfo[2] = rightRNode;
				diameterInfo[3] = leftRNode;
			}
			// Update the maximum diameter
			diameterInfo[1] = leftDepth + rightDepth + 1;
		}
		
		diameterInfo[0] = leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
	}
}