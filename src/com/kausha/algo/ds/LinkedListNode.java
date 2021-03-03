package com.kausha.algo.ds;

public class LinkedListNode {

	public String data;
	public LinkedListNode next;
	public LinkedListNode rnd;
	public int num;
	
	public LinkedListNode(String data){
		this.data = data;
	}
	
	public LinkedListNode(int num){
		this.num = num;
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
