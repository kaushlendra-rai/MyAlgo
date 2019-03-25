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

	private static LinkedListNode reversedLinkedList(LinkedListNode node) {
		FirstNodeHolder holder = new FirstNodeHolder();
		LinkedListNode reversedList = reverse(node, holder);
		reversedList.next = null;
		
		return holder.node;
	}
	
	private static LinkedListNode reverse(LinkedListNode node, FirstNodeHolder holder) {
		if(node == null || node.next == null){
			holder.node = node;
			return node;
		}
		
		LinkedListNode temp = reverse(node.next, holder);
		temp.next = node;
		
		return node;
	}
}

class FirstNodeHolder{
	LinkedListNode node;
}