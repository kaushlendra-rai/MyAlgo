package com.kausha.algo.gfg.microsoft;

public class DeleteWithoutHeadPointerLinkedList {

	public static void main(String[] args) {
		DeleteWithoutHeadPointerLinkedList dp = new DeleteWithoutHeadPointerLinkedList();
		Node node = new Node(1);
		Node node1 = new Node(5);
		Node node2 = new Node(9);
		Node node3 = new Node(11);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		
		dp.deleteNode(node);
		
		while(node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	//just copy the next node to current node and delete the next node.
	void deleteNode(Node del) {
         del.data = del.next.data;
         del.next = del.next.next;
    }
}