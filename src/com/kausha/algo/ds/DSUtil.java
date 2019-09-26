package com.kausha.algo.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class DSUtil {
	public static TreeNode getBinaryTree(){
		TreeNode root = new TreeNode(20);
		TreeNode Node1 = new TreeNode(22);
		TreeNode Node2 = new TreeNode(32);
		TreeNode Node3 = new TreeNode(24);
		
		TreeNode Node4 = new TreeNode(26);
		TreeNode Node5 = new TreeNode(7);
		
		TreeNode Node6 = new TreeNode(52);
		TreeNode Node7 = new TreeNode(552);
		TreeNode Node8 = new TreeNode(23);
		TreeNode Node9 = new TreeNode(25);
		TreeNode Node10 = new TreeNode(21);
		
		root.left = Node5;
		root.right = Node4;
		
		Node4.left = Node1;
		Node4.right = Node2;
		
		Node2.right = Node6;
		
		Node1.right = Node3;
		
		Node6.right = Node7;
		
		Node3.left = Node8;
		Node3.right = Node9;
		
		Node1.left = Node10;
		
		// Uncomment it to make it an invalid BST
		/*TreeNode Node8 = new TreeNode(2);
		Node7.right = Node8;*/
		
		return root;
	}
	
	public static TreeNode getBinaryTreeImage(){
		//TreeNode root = new TreeNode(20);
		TreeNode root = new TreeNode(20);
		TreeNode Node1 = new TreeNode(22);
		TreeNode Node2 = new TreeNode(32);
		TreeNode Node3 = new TreeNode(24);
		
		TreeNode Node4 = new TreeNode(26);
		TreeNode Node5 = new TreeNode(7);
		
		TreeNode Node6 = new TreeNode(52);
		TreeNode Node7 = new TreeNode(552);
		TreeNode Node8 = new TreeNode(23);
		TreeNode Node9 = new TreeNode(25);
		TreeNode Node10 = new TreeNode(21);
		
		root.right = Node5;
		root.left = Node4;
		
		Node4.right = Node1;
		Node4.left = Node2;
		
		Node2.left = Node6;
		
		Node1.left = Node3;
		
		Node6.left = Node7;
		
		Node3.right = Node8;
		Node3.left = Node9;
		
		Node1.right = Node10;
		
		// Uncomment it to make it an invalid BST
		/*TreeNode Node8 = new TreeNode(2);
		Node7.right = Node8;*/
		
		return root;
	}
	
	public static TreeNode getBinaryTree2(){
		TreeNode node0 = new TreeNode(32);
		TreeNode node1 = new TreeNode(22);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(24);
		
		TreeNode node4 = new TreeNode(26);
		TreeNode node5 = new TreeNode(7);
		
		TreeNode node6 = new TreeNode(52);
		TreeNode node7 = new TreeNode(552);
		
		TreeNode node8 = new TreeNode(5);
		
		node0.left = node3;
		node0.right = node6;
		
		node3.left = node1;
		node3.right = node4;
		
		node1.left = node2;
		
		node6.right = node7;
		
		node2.left = node5;
		
		node5.left = node8;
		
		return node0;
	}
	
	public static void printTree(TreeNode root){
		if(root == null){
			System.out.println("TreeNode is empty");
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			System.out.print(node.value + " ");
			
			if(node.left != null)
				queue.offer(node.left);
			
			if(node.right != null)
				queue.offer(node.right);
		}
	}
	
	public static void printTreeRecursively(TreeNode root) {
		if(root == null)
			return;
		
		printTreeRecursively(root.left);
		System.out.print(root.value + " ");
		printTreeRecursively(root.right);
	}
	
	public static LinkedListNode generateNumericLinkedList(){
		LinkedListNode node1 = new LinkedListNode("1");
		LinkedListNode node2 = new LinkedListNode("2");
		LinkedListNode node3 = new LinkedListNode("3");
		LinkedListNode node4 = new LinkedListNode("4");
		LinkedListNode node5 = new LinkedListNode("5");
		LinkedListNode node6 = new LinkedListNode("6");
		LinkedListNode node7 = new LinkedListNode("7");
		LinkedListNode node8 = new LinkedListNode("8");
		//LinkedListNode node9 = new LinkedListNode("z");
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		//node8.next = node9;
		
		return node1;
	}
	
	public static LinkedListNode generateLinkedList(){
		LinkedListNode node1 = new LinkedListNode("a");
		LinkedListNode node2 = new LinkedListNode("b");
		LinkedListNode node3 = new LinkedListNode("c");
		LinkedListNode node4 = new LinkedListNode("d");
		LinkedListNode node5 = new LinkedListNode("e");
		LinkedListNode node6 = new LinkedListNode("f");
		LinkedListNode node7 = new LinkedListNode("g");
		LinkedListNode node8 = new LinkedListNode("h");
		//LinkedListNode node9 = new LinkedListNode("z");
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		//node8.next = node9;
		
		return node1;
	}
	
	public static LinkedListNode generatePalindromeLinkedList(){
		LinkedListNode node1 = new LinkedListNode("a");
		LinkedListNode node2 = new LinkedListNode("b");
		LinkedListNode node3 = new LinkedListNode("c");
		LinkedListNode node4 = new LinkedListNode("d");
		LinkedListNode node5 = new LinkedListNode("d");
		LinkedListNode node6 = new LinkedListNode("c");
		LinkedListNode node7 = new LinkedListNode("b");
		LinkedListNode node8 = new LinkedListNode("a");
		//LinkedListNode node9 = new LinkedListNode("z");
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		//node8.next = node9;
		
		return node1;
	}
	
	public static void printLinkedList(LinkedListNode node){
		while(node!=null){
			System.out.print(node.data + " --> ");
			node = node.next;
		}
	}
	
	public static DoublyLinkedListNode generateDoubblyLinkedList(){
		DoublyLinkedListNode node1 = new DoublyLinkedListNode("1");
		DoublyLinkedListNode node2 = new DoublyLinkedListNode("2");
		DoublyLinkedListNode node3 = new DoublyLinkedListNode("3");
		DoublyLinkedListNode node4 = new DoublyLinkedListNode("4");
		DoublyLinkedListNode node5 = new DoublyLinkedListNode("5");
		DoublyLinkedListNode node6 = new DoublyLinkedListNode("6");
		DoublyLinkedListNode node7 = new DoublyLinkedListNode("7");
		DoublyLinkedListNode node8 = new DoublyLinkedListNode("8");
		DoublyLinkedListNode node9 = new DoublyLinkedListNode("9");
		//LinkedListNode node9 = new LinkedListNode("z");
		
		node1.next = node2;
		node2.prev = node1;
		
		node2.next = node3;
		node3.prev = node2;
		
		node3.next = node4;
		node4.prev = node3;
		
		node4.next = node5;
		node5.prev = node4;
		
		node5.next = node6;
		node6.prev = node5;
		
		node6.next = node7;
		node7.prev = node6;
		
		node7.next = node8;
		node8.prev = node7;
		
		node8.next = node9;
		node9.prev = node8;
		
		return node1;
	}
	
	public static void printDLL(DoublyLinkedListNode dll){
		System.out.println("\n");
		while(dll != null){
			System.out.print(dll.data + " ");
			dll = dll.next;
		}
	}
	
	public static void printCircularDLL(TreeNode root) {
		TreeNode node = root.right;
		System.out.print(root.value + " ");
		while(node != root){
			System.out.print(node.value + " ");
			node = node.right;
		}
		
		System.out.println();
	}

	public static GraphNode getGraph(){
		GraphNode root = new GraphNode(20);
		GraphNode Node1 = new GraphNode(22);
		GraphNode Node2 = new GraphNode(32);
		GraphNode Node3 = new GraphNode(24);
		List<GraphNode> adj1 = new ArrayList<GraphNode>();
		adj1.add(Node1);
		adj1.add(Node2);
		adj1.add(Node3);
		root.setAdjscentNodes(adj1);
		
		
		GraphNode Node4 = new GraphNode(26);
		GraphNode Node5 = new GraphNode(7);
		
		List<GraphNode> adj2 = new ArrayList<GraphNode>();
		adj2.add(Node4);
		adj2.add(Node5);
		adj2.add(Node2);
		Node1.setAdjscentNodes(adj2);
		
		GraphNode Node6 = new GraphNode(52);
		GraphNode Node7 = new GraphNode(552);
		
		List<GraphNode> adj3 = new ArrayList<GraphNode>();
		adj3.add(Node6);
		adj3.add(Node7);
		adj3.add(Node5);
		Node4.setAdjscentNodes(adj3);
		
		return root;
	}
}