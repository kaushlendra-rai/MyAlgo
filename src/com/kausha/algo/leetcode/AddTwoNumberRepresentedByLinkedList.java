package com.kausha.algo.leetcode;

public class AddTwoNumberRepresentedByLinkedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(9);
		l1.next = l2;
		l2.next = l3;
		
		ListNode r1 = new ListNode(5);
		ListNode r2 = new ListNode(6);
		ListNode r3 = new ListNode(4);
		r1.next = r2;
		r2.next = r3;
		
		ListNode sum = addTwoNumbers(l1, r1);
		while(sum != null) {
			System.out.print(sum.val + " -> ");
			sum = sum.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode start = null;
		ListNode node = null;
		int carry = 0;
		int sum = 0;
		while(l1 != null || l2 != null) {
			sum = carry;
			if(l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			ListNode newNode = new ListNode(sum%10);
			if(start == null)
				start = newNode;
			if(node == null)
				node = newNode;
			else {
				node.next = newNode;
				node = node.next;
			}
			carry = sum/10;
		}
		
		if(carry != 0) {
			ListNode newNode = new ListNode(carry);
			node.next = newNode;
		}
		
		return start;
    }

}

class ListNode {
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
