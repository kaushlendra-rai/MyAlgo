package com.kausha.algo.ds;

public class BSTDistanceBetweenTwoTreeNodes {
	public static void main(String[] args) {
		TreeNode node = DSUtil.getBinaryTree();
		TreeNode node1 = new TreeNode(26);// 52 & 24 have common ancestor via 26. Distance = 4
		TreeNode node2 = new TreeNode(52); // 26 & 52 are in same line.. Distance = 2
		System.out.println(findDistanceBetweenNodes(node, node1, node2));
	}
	
	private static int findDistanceBetweenNodes(TreeNode node, TreeNode node1, TreeNode node2) {
		if(node1.equals(node2))
			return 0;
		
		int[] dist = new int[3];
		findDistanceBetweenNodes(node, node1, node2, dist);
		System.out.println("dist[0]: " + dist[0] + "  , " + dist[1] + " , "  + dist[2]);
		return dist[0];
	}

	private static TreeNode findDistanceBetweenNodes(TreeNode node, TreeNode node1, TreeNode node2, int[] dist) {
		if(node == null)
			return null;
		
		TreeNode match = null;
		if(node.equals(node1) || node.equals(node2)) {
			match = node;
		}
	
		TreeNode left = findDistanceBetweenNodes(node.left, node1, node2, dist);
		TreeNode right = findDistanceBetweenNodes(node.right, node1, node2, dist);
	
		// We have found common ancestor
		if((node1 == left || node1 == right) && (node2 == left || node2 == right)) {
			dist[0] = dist[1] + dist[2];
			return null;
		}else if(match != null && (left != null || right != null)){ // match in same line
			dist[0] = Math.max(dist[1], dist[2]);
			return null;
		}else if (node1.equals(left) || node1.equals(right)) {
			dist[1] +=1;
			return node1;
		}else if(node2.equals(left) || node2.equals(right)) {
			dist[2] +=1;
			return node2;
		}else if(node1.equals(match)) {
			dist[1] +=1;
		}else if(node2.equals(match)) {
			dist[2] +=1;
		}
		
		return match;
	}
}