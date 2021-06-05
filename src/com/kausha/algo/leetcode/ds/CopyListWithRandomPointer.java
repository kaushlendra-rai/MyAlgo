package com.kausha.algo.leetcode.ds;

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		CopyListWithRandomPointer clrp = new CopyListWithRandomPointer();
		Node head = new Node(3);
		Node node1 = new Node(4);
		Node node2 = new Node(5);
		
		head.next = node1;
		head.random = node2;
		
		node1.next = node2;
		node1.random = head;
		
		node2.random = node1;
		
		//Node copy = clrp.copyRandomList(head);

		//Node copy = clrp.copyRandomList(null);
		//Node copy = clrp.copyRandomList(new Node(8));
		
		Node copy = clrp.copyRandomList(head);
		if(copy == null) 
			System.out.println("Null copy");
		else
			//System.out.println(copy.val + " , " + copy.random.val);
			System.out.println(copy.val);
		System.out.println("****************************");
		while(head != null) {
			System.out.print(head.val + " ->");
			head = head.next;
		}
		System.out.println("****************************");
		while(copy != null) {
			System.out.print(copy.val + " ->");
			copy = copy.next;
		}
	}

	public Node copyRandomList(Node head) {
		if(head == null)
			return null;
		// We first embed one node after each node and copy the value of current node to it.
		Node node = head;
		while(node != null) {
			Node copy = new Node(node.val);
			copy.next = node.next;
			node.next = copy;
			node= node.next.next;
		}

		// Now lets copy the random pointer
		node = head;
		while(node != null) {
			if(node.random != null) {
				node.next.random = node.random.next;
			}
			node = node.next.next;
		}

		// Now lets separate the original and copy nodes of the linked list.
		node = head;
		Node copyNode = head.next;
		Node newHead = head.next;
		while(copyNode != null) {
			if(copyNode.next != null) {
				node.next = node.next.next;
				copyNode.next = copyNode.next.next;
			}else {
				node.next = null;
			}
			node = node.next;
			copyNode = copyNode.next;
		}
        return newHead;
    }
}

class Node {
    int val;
    Node next;
    Node left;
    Node right;
    Node random;

    public Node() {}
    
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}