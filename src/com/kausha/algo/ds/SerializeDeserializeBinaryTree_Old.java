package com.kausha.algo.ds;

public class SerializeDeserializeBinaryTree_Old {

	public static void main(String[] args) {
		TreeNode root = DSUtil.getBinaryTree();
		DSUtil.printTreeRecursively(root);
		System.out.println("\n");
		String ser = serializeBinaryTree(root);
		System.out.println(ser);
		TreeNode tree = deserializeBinaryTree(ser);
		System.out.println();
		DSUtil.printTreeRecursively(tree);
	}

	private static String serializeBinaryTree(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serializeBinaryTree(root, sb);
		
		return sb.toString();
	}
	
	private static void serializeBinaryTree(TreeNode node, StringBuilder sb) {
		if(node == null) {
			sb.append("# ");
			return;
		}
		sb.append(node.value).append(" ");
		
		serializeBinaryTree(node.left, sb);
		serializeBinaryTree(node.right, sb);
	}
	
	private static TreeNode deserializeBinaryTree(String ser) {
		String[] vals = ser.split(" ");
		Object[] index = new Object[1];
		index[0] = 0;
		
		return deserializeBinaryTree(vals, index);
	}
	
	private static TreeNode deserializeBinaryTree(String[] vals, Object[] index) {
		int idx = (Integer)index[0];
		if(vals[idx].equals("#"))
			return null;
		
		TreeNode node = new TreeNode(Integer.parseInt(vals[idx]));
		// Left node
		index[0] = ++idx;
		if(vals[idx] != "#")
			node.left = deserializeBinaryTree(vals, index);
		
		// Right node
		idx = (Integer)index[0] + 1;
		index[0] = idx;

		if(vals[idx] != "#")
			node.right = deserializeBinaryTree(vals, index);
		
		return node;
	}
}
