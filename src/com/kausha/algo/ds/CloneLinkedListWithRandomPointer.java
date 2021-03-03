package com.kausha.algo.ds;

public class CloneLinkedListWithRandomPointer {

	public static void main(String[] args) {
		LinkedListNode node = getLinkedListNodeWithRandomPointer();
		LinkedListNode clone = cloneLinkedListWithRandomPointer(node);
		while(clone != null) {
			System.out.println(clone.num);
			clone = clone.next;
		}
	}

	private static LinkedListNode cloneLinkedListWithRandomPointer(LinkedListNode root) {
		if (root == null)
			return null;
		
		LinkedListNode node = root;
		// add the clone node with same value next to original node.
		while(node != null) {
			LinkedListNode clone = new LinkedListNode(node.num);
			LinkedListNode temp = node.next;
			
			node.next = clone;
			clone.next = temp;
			node = temp;
		}
		
		// Now copy the random pointer node to the cloned node.
		node = root;
		while(node != null) {
			node.next.rnd = node.rnd.next;
			node = node.next.next;
		}
		
		LinkedListNode org = root;
		LinkedListNode clone = null;
		LinkedListNode cloneRoot = null;
		// Now split the two linked lists
		while(org != null) {
			LinkedListNode temp = org.next;
			org.next = temp.next;
			if(clone == null) {
				cloneRoot = temp;
				clone = temp;
			}else {
				clone.next = temp;
				clone = clone.next;
			}
			org = org.next;
		}
		
		return cloneRoot;
	}

	public static LinkedListNode getLinkedListNodeWithRandomPointer() {
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node4 = new LinkedListNode(4);
		LinkedListNode node5 = new LinkedListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		node1.rnd = node3;
		node2.rnd = node5;
		node3.rnd = node4;
		node4.rnd = node1;
		node5.rnd = node2;
		return node1;
	}
}
