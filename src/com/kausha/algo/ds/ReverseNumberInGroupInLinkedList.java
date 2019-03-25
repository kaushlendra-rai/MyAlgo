package com.kausha.algo.ds;

public class ReverseNumberInGroupInLinkedList {
	public static void main(String[] args) {
		LinkedListNode node = DSUtil.generateLinkedList();
		System.out.println("Input List:");
		DSUtil.printLinkedList(node);
		int groupSize = 3;
		LinkedListNode reversedList = reversedLinkedListInGroups(node, groupSize);
		System.out.println("Output List:");
		DSUtil.printLinkedList(reversedList);
	}

	private static LinkedListNode reversedLinkedListInGroups(LinkedListNode node, int groupSize) {
		if(node == null || node.next == null)
			return node;
		
		LinkedListNode start = null;
		LinkedListNode first = null;
		while(node!= null && node.next != null){
			LinkedListNode newNode = reverseLinkedList(node, groupSize-1);
			
			// Join the reversed list & maintain the new start node
			if(first == null){
				start = newNode;
				first = newNode;
			}else{
				first = traverseNodes(first, groupSize-1);
				first.next = newNode;
				first = first.next;
			}
			
			node = traverseNodes(newNode, groupSize);
		}
		
		return start;
	}
	
	private static LinkedListNode traverseNodes(LinkedListNode node, int groupSize) {
		int counter = 0;
		while(node != null && counter++ < groupSize){
			node = node.next;
		}
		
		return node;
	}

	private static LinkedListNode reverseLinkedList(LinkedListNode node, int groupSize){
		if(node == null || node.next == null)
			return node;
		
		LinkedListNode temp = null;
		LinkedListNode first = node;
		int counter = 0;
		while(node.next != null && counter < groupSize){
			temp = node.next.next;
			node.next.next = first;
			first = node.next;
			node.next = temp;
			
			counter++;
		}
		
		return first;
	}
}