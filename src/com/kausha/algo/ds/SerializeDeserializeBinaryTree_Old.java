package com.kausha.algo.ds;

public class SerializeDeserializeBinaryTree_Old {

	public static void main(String[] args) {
		TreeNode root = DSUtil.getBinaryTree();
		DSUtil.printTreeRecursively(root);
		System.out.println("\n");
		String ser = serializeBinaryTree(root);
		System.out.println(ser);
		TreeNode tree = deserializeBinaryTree(ser);
		//DSUtil.printTreeRecursively(tree);
	}

	private static String serializeBinaryTree(TreeNode node) {
		StringBuilder sb = new StringBuilder();
		serializeBinaryTree(node, sb);
		
		return sb.toString();
	}
	
	private static void serializeBinaryTree(TreeNode node, StringBuilder sb) {
		if(node == null) {
			sb.append("nil ");
			return;
		}
		
		sb.append(node.value).append(" ");
		serializeBinaryTree(node.left, sb);
		serializeBinaryTree(node.right, sb);
		
		return;
	}

	private static TreeNode deserializeBinaryTree(String ser) {
		TreeNode root = new TreeNode();
		String[] nodeVals = ser.split(" ");
		root.value = Integer.parseInt(nodeVals[0]);
		deserializeBinaryTree(nodeVals, 1, root);
		return root;
	}

	private static void deserializeBinaryTree(String[] ser, int index, TreeNode node) {
		
		if("nil".equals(ser[index])) {
			return;
		}
		TreeNode newNode = new TreeNode(Integer.parseInt(ser[index]));
		deserializeBinaryTree(ser, index +1, newNode.left);
		
		return;
	}
}
