package com.kausha.algo.ds;

public class BSTDistanceBetweenTwoBinaryTree {
	public static void main(String[] args) {
		TreeNode node = DSUtil.getBinaryTree();
		TreeNode node1 = new TreeNode(26);// 52 & 24 have common ancestor via 26. Distance = 4
		TreeNode node2 = new TreeNode(52); // 26 & 52 are in same line.. Distance = 2
		System.out.println(findDistanceBetweenNodes(node, node1, node2));
	}

	private static int findDistanceBetweenNodes(TreeNode node, TreeNode node1, TreeNode node2) {
		int[] dist = new int[3];
		dist[2] = -1;
		
		findDistanceBetweenNodes(node, node1, node2, dist);
		System.out.println("dist[0]: " + dist[0] + "  , " + dist[1] + " , "  + dist[2]);
		return dist[2];
	}
	
	private static TreeNode findDistanceBetweenNodes(TreeNode node, TreeNode node1, TreeNode node2, int[] dist) {
		if(node == null)
			return null;
		
		TreeNode match = null;
		if(node1.equals(node) || node2.equals(node))
			match = node;
		
		TreeNode left = findDistanceBetweenNodes(node.left, node1, node2, dist);
		TreeNode right = findDistanceBetweenNodes(node.right, node1, node2, dist);
		
		// Check if both match found from different branches
		if((node1.equals(left) || node1.equals(right)) && (node2.equals(left) || node2.equals(right))) {
			dist[2] = dist[0] + dist[1];
			System.out.println("Lowest Common Ancestor: " + node.value);
			return  null;
		}else if(match != null && (node1.equals(left) || node1.equals(right) || node2.equals(left) || node2.equals(right))) {
			// Match found in same line.
			dist[2] = Math.abs(dist[0]-dist[1]);
			System.out.println("Lowest Common Ancestor in same line: " + match.value);
			return null;
		}else if(node1.equals(left) || node2.equals(left)) {
			calculateDistance(left, node1, node2, dist);
			return left;
		}else if(node1.equals(right) || node2.equals(right)) {
			calculateDistance(right, node1, node2, dist);
			return right;
		}
		calculateDistance(match, node1, node2, dist);
		return match;
	}
	
	private static void calculateDistance(TreeNode node, TreeNode node1, TreeNode node2, int[] dist) {
		if (node1.equals(node))
			dist[0] += 1;
		else if(node2.equals(node))
			dist[1] += 1;
	}
}