package com.kausha.algo.ds;

public class ReverseLinkedListIteratively_1 {
	public static void main(String[] args) {
		LinkedListNode node = DSUtil.generateLinkedList();
		System.out.println("Input List:");
		DSUtil.printLinkedList(node);
		LinkedListNode reversedList = reversedLinkedList(node);
		System.out.println("Output List:");
		DSUtil.printLinkedList(reversedList);
	}

	private static LinkedListNode reversedLinkedList(LinkedListNode node) {
		if(node == null)
			return null;
		
		LinkedListNode firstNode = node;
		LinkedListNode temp = null;
		
		while(node.next != null){
			temp = node.next.next;
			node.next.next = firstNode;
			firstNode = node.next;
			node.next = temp;
		}
		
		return firstNode;
	}
}