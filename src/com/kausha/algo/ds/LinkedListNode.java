package com.kausha.algo.ds;

public class LinkedListNode {

	public String data;
	public LinkedListNode next;
	
	public LinkedListNode(String data){
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public LinkedListNode getNext() {
		return next;
	}
	public void setNext(LinkedListNode next) {
		this.next = next;
	}
}
