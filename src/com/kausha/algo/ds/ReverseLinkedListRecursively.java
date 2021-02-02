package com.kausha.algo.ds;

public class ReverseLinkedListRecursively {

	public static void main(String[] args) {
		LinkedListNode node = DSUtil.generateLinkedList();
		System.out.println("Input List:");
		DSUtil.printLinkedList(node);
		
		LinkedListNode reversedLinkedList = reversedLinkedList(node);
		System.out.println("\nOutput List:");
		DSUtil.printLinkedList(reversedLinkedList);
	}

	// Using circular linked list to maintain the final reversed root to be returned.
	private static LinkedListNode reversedLinkedList(LinkedListNode node) {
		if(node == null)
			return null;
		
		LinkedListNode reversedLL = reversedCircularLinkedList(node);
		LinkedListNode root = reversedLL.next;
		// Break the Circular LinkedList
		reversedLL.next = null;
		
		return root;
	}
	
	private static LinkedListNode reversedCircularLinkedList(LinkedListNode node) {
		if(node.next == null) {
			node.next = node;
			return node;
		}
		
		LinkedListNode returnedNode = reversedCircularLinkedList(node.next);
		LinkedListNode temp = returnedNode.next;
		returnedNode.next = node;
		
		node.next = temp;
		
		return node;
	}
}
