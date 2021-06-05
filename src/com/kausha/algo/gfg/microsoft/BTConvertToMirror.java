package com.kausha.algo.gfg.microsoft;

public class BTConvertToMirror {

	public static void main(String[] args) {
		BTConvertToMirror cm = new BTConvertToMirror();
		
		Node root = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		
		cm.mirror(root);
		System.out.println(root.left.data);
		System.out.println(root.right.data);
		System.out.println(root.right.left.data);
		System.out.println(root.right.right.data);
	}

	void mirror(Node node)
    {
		mirrorImage(node);
    }
	
	Node mirrorImage(Node node) {
		if(node == null)
			return null;
		
		Node left = mirrorImage(node.left);
		Node right = mirrorImage(node.right);
		node.left = right;
		node.right = left;
		
		return node;
	}
}
