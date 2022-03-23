package com.kausha.algo.ds;

public class ReverseDoublyLinkedList {
	public static void main(String[] args) {
		DoublyLinkedListNode dll = DSUtil.generateDoubblyLinkedList();
		DSUtil.printDLL(dll);
		//DoublyLinkedListNode reversedDLL = reverseDLL(dll);
		DoublyLinkedListNode reversedDLL = reverseDLL(dll);
		//DoublyLinkedListNode reversedDLL = reverseDLL2(dll);
		DSUtil.printDLL(reversedDLL);
	}
	
	private static DoublyLinkedListNode reverseDLL(DoublyLinkedListNode dll) {
		while(dll != null){
			DoublyLinkedListNode temp = dll.next;
			dll.next = dll.prev;
			dll.prev = temp;
			
			if(dll.prev == null)
				break;
			else
				dll = dll.prev;
		}
		
		return dll;
	}
	
	private static DoublyLinkedListNode reverseDLL2(DoublyLinkedListNode dll) {
		DoublyLinkedListNode prev = null;
		while(dll != null){
			DoublyLinkedListNode temp = dll.next;
			dll.next = prev;
			dll.prev = temp;
			
			prev = dll;
			dll = temp;
		}
		
		return prev;
	}
}