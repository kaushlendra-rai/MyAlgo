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
		String[] nums = ser.split(" ");
		if("#".equals(nums[0]))
			return null;
		
		int nodeIndexCounter = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			String left = nums[++nodeIndexCounter];
			String right = nums[++nodeIndexCounter];

			if(!"#".equals(left)) {
				node.left = new TreeNode(Integer.parseInt(left));
				queue.offer(node.left);
			}
			if(!"#".equals(right)) {
				node.right = new TreeNode(Integer.parseInt(right));
				queue.offer(node.right);
			}
		}
		
		return root;
	}
}