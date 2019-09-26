package com.kausha.algo.ds;


public class SortedDLLToBST {
	public static void main(String[] args) {
		DoublyLinkedListNode start = DSUtil.generateDoubblyLinkedList();
		
		DoublyLinkedListNode root = convertDLLToBST(start);
		System.out.println("Root = " + root.data);
		System.out.println("root.prev.data = " + root.prev.data);
		System.out.println("root.next.data = " + root.next.data);
		
		System.out.println("root.prev.prev.data = " + root.prev.prev.data);
		System.out.println("root.prev.next.data = " + root.prev.next.data);
		
		System.out.println("root.next.prev.data = " + root.next.prev.data);
		System.out.println("root.next.next.data = " + root.next.next.data);
	}

	private static DoublyLinkedListNode convertDLLToBST(DoublyLinkedListNode start){
		if(start == null)
			return null;
		
		DoublyLinkedListNode node = start;
		int lengthOfDLL = 0;
		while(node != null){
			node = node.next;
			lengthOfDLL++;
		}

		return convertDLLToBST(start, lengthOfDLL);
		/*
		 * Object[] refNode = new Object[1]; refNode[0] = start;
		 * 
		 * return convertDLLToBST(refNode, lengthOfDLL);
		 */
	}
	
	private static DoublyLinkedListNode convertDLLToBST(DoublyLinkedListNode node, int lengthOfDLL) {
		
		if(lengthOfDLL <= 0)
			return null;
		//System.out.println("lengthOfDLL = " + lengthOfDLL);
		//System.out.println("lengthOfDLL = " + lengthOfDLL + " NODE = " + node.data);
		DoublyLinkedListNode left = convertDLLToBST(node, lengthOfDLL/2);
		DoublyLinkedListNode root = node;
		DoublyLinkedListNode right = null;
		if(node.next != null)
			right = convertDLLToBST(node.next, lengthOfDLL - lengthOfDLL/2 -1);
		
		root.prev = left;
		root.next = right;
		
		return root;
	}
	
	private static DoublyLinkedListNode convertDLLToBST2(Object[] nodeRef, int lengthOfDLL) {
		System.out.println("lengthOfDLL = " + lengthOfDLL);
		if(lengthOfDLL <= 0)
			return null;
		
		DoublyLinkedListNode left = convertDLLToBST2(nodeRef, lengthOfDLL/2);
		
		DoublyLinkedListNode node = (DoublyLinkedListNode)nodeRef[0];
		DoublyLinkedListNode root = node;
		
		nodeRef[0] = node.next;
		DoublyLinkedListNode right = convertDLLToBST2(nodeRef, lengthOfDLL - lengthOfDLL/2 -1);
		
		root.prev = left;
		root.next = right;
		
		return root;
	}
}