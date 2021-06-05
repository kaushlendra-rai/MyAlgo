package com.kausha.algo.gfg.microsoft;

// https://practice.geeksforgeeks.org/problems/height-of-binary-tree
public class HeightOfBinaryTree {

	public static void main(String[] args) {
		HeightOfBinaryTree hbt = new HeightOfBinaryTree();
		
//		Node root = new Node(1);
//		Node node1 = new Node(2);
//		Node node2 = new Node(3);
//		Node node3 = new Node(4);
//		Node node4 = new Node(5);
//		root.left = node1;
//		root.right = node2;
//		node1.left = node3;
//		node1.right = node4;
		
//		Node root = new Node(1);
//		Node node1 = new Node(2);
//		Node node2 = new Node(3);
//		root.left = node1;
//		root.right = node2;
		
		Node root = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		root.left = node1;
		node1.right = node2;
		
		System.out.println(hbt.height(root));
	}

	int height(Node node) 
    {
		if(node == null)
			return 0;
		
        int left = height(node.left);
        int right = height(node.right);
        
        return Math.max(left, right) +1;
    }
	
	
}
