package com.kausha.algo.ds;

public class DoublyLinkedListNode {

	public String data;
	public DoublyLinkedListNode next;
	public DoublyLinkedListNode prev;
	
	public DoublyLinkedListNode getPrev() {
		return prev;
	}

	public void setPrev(DoublyLinkedListNode prev) {
		this.prev = prev;
	}

	public DoublyLinkedListNode(String data){
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public DoublyLinkedListNode getNext() {
		return next;
	}
	public void setNext(DoublyLinkedListNode next) {
		this.next = next;
	}
}
