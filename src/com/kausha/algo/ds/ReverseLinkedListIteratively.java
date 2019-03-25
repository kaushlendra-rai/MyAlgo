package com.kausha.algo.ds;

public class ReverseLinkedListIteratively {
	public static void main(String[] args) {
		LinkedListNode node = DSUtil.generateLinkedList();
		System.out.println("Input List:");
		DSUtil.printLinkedList(node);
		LinkedListNode reversedList = reversedLinkedList(node);
		System.out.println("Output List:");
		DSUtil.printLinkedList(reversedList);
	}

	private static LinkedListNode reversedLinkedList(LinkedListNode node) {
		LinkedListNode prev = null;
		
		while(node != null){
			LinkedListNode temp = node.next;
			node.next = prev;
			prev = node;
			node = temp;
		}
		
		return prev;
	}
}