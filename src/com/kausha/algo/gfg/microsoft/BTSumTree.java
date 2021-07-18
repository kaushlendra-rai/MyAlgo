package com.kausha.algo.gfg.microsoft;

public class BTSumTree {

	public static void main(String[] args) {
		BTSumTree st = new BTSumTree();
		
		Node root = new Node(10);
		Node node1 = new Node(-2);
		Node node2 = new Node(6);
		Node node3 = new Node(8);
		Node node4 = new Node(-4);
		Node node5 = new Node(7);
		Node node6 = new Node(5);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;

		st.toSumTree(root);
		
		System.out.println(root.data);
	}

	public void toSumTree(Node root){
        if(root == null)
        	return;
        sumTree(root);
   }
	
	private int sumTree(Node root){
        if(root == null)
        	return 0;
        
        int left = sumTree(root.left);
        int right = sumTree(root.right);
        
        int returnVal = root.data + left + right;
        root.data = left + right;
        
        return returnVal;
   }
}
