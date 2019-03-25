package com.kausha.algo.ds;

//http://www.crazyforcode.com/inorder-successor-binary-search-tree/
public class InOrderSuccessorOfBST {
	public static void main(String[] args) {
		TreeNode node = DSUtil.getBinaryTree();
		TreeNode node2 = node.right.left.left;
		
		TreeNode result = inOrderSuccessor(node, node2);
		if(result != null)
			System.out.println("Successor : " + result.value);
		else
			System.out.println("Value does not exist in the tree");
	}

	private static TreeNode inOrderSuccessor(TreeNode node, TreeNode node2) {
		
		if(node == null || node2 == null)
			return null;
		
		if(node2.right != null){
			node2 = node2.right;
			while(node2.left != null){
				node2 = node2.left;
			}
			
			return node2;
		}
		
		TreeNode succ = node;
		while(node != null){
			if(node.value > node2.value){
				succ = node;
				node = node.left;
			}else if(node.value < node2.value){
				node = node.right;
			}else
				break;
		}
		
		return succ;
	}
}