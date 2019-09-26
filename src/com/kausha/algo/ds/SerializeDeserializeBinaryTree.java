package com.kausha.algo.ds;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

	public static void main(String[] args) {
		TreeNode root = DSUtil.getBinaryTree();
		DSUtil.printTreeRecursively(root);
		System.out.println("\n");
		String ser = serializeBinaryTree(root);
		System.out.println(ser);
		TreeNode tree = deserializeBinaryTree(ser);
		DSUtil.printTreeRecursively(tree);
	}

	private static String serializeBinaryTree(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node == null) {
				sb.append("# ");
			}else {
				sb.append(node.value).append(" ");
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}
		
		return sb.toString();
	}
	
	private static TreeNode deserializeBinaryTree(String ser) {
		String[] vals = ser.split(" ");
		int arrayCounter = 0;
		// If teh node sent for serialization was null, value at '0' index would be '#'
		if("#".equals(vals[0]))
			return null;
		
		TreeNode root = new TreeNode(Integer.parseInt(vals[arrayCounter++]));
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			
			if(node != null) {
				TreeNode left = null;
				if(!"#".equals(vals[arrayCounter])) {
					left = new TreeNode(Integer.parseInt(vals[arrayCounter]));
				}
				node.left = left;
				queue.offer(left);
				arrayCounter++;
				
				TreeNode right = null;
				if(!"#".equals(vals[arrayCounter])) {
					right = new TreeNode(Integer.parseInt(vals[arrayCounter]));
				}
				node.right = right;
				queue.offer(right);
				arrayCounter++;
			}
		}
		
		return root;
	}
}