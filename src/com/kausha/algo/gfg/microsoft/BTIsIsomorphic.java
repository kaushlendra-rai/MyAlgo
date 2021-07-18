package com.kausha.algo.gfg.microsoft;

public class BTIsIsomorphic {

	public static void main(String[] args) {
		BTIsIsomorphic bi = new BTIsIsomorphic();
//		Node root = new Node(1);
//		Node node1 = new Node(2);
//		Node node2 = new Node(3);
//		Node node3 = new Node(4);
//		Node node4 = new Node(5);
//		root.left = node1;
//		root.right = node2;
//		node1.left = node3;
//		node1.right = node4;
//		
//		Node root2 = new Node(1);
//		Node node21 = new Node(2);
//		Node node22 = new Node(3);
//		Node node23 = new Node(4);
//		Node node24 = new Node(5);
//		root2.right = node21;
//		root2.left = node22;
//		node21.right = node23;
//		node21.left = node24;
		
		Node root1 = new Node(8);
		Node node11 = new Node(9);
		Node node12 = new Node(8);
		Node node13 = new Node(4);
		root1.left = node11;
		root1.right = node12;
		node11.left = node13;
		
		Node root2 = new Node(8);
		Node node21 = new Node(9);
		Node node22 = new Node(8);
		Node node23 = new Node(4);
		root2.right = node21;
		root2.left = node22;
		node21.right = node23;
		
		System.out.println(bi.isIsomorphic(root1, root2));
	}

	boolean isIsomorphic(Node root1, Node root2)  
    {
		if(root1 == null && root2 == null)
			return true;
		else if(root1 == null || !root1.equals(root2)) {
			return false;
		}
		
		return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)) ||
			(isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));
    }
}
