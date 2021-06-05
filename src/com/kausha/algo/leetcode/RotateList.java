package com.kausha.algo.leetcode;

// https://leetcode.com/problems/rotate-list/
// Given the head of a linked list, rotate the list to the right by k places.
public class RotateList {

	public static void main(String[] args) {
		RotateList rl = new RotateList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
//		ListNode n1 = new ListNode(1);
//		ListNode n2 = new ListNode(2);
//		ListNode n3 = new ListNode(3);
//		n1.next = n2;
//		n2.next = n3;
		
		ListNode rotated = rl.rotateRight(n1, 4);
		
		while(rotated != null) {
			System.out.print(rotated.val + " ");
			rotated = rotated.next;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
		if(head == null)
			return null;
		
		ListNode node = head;
		int len = 1;
		while(node.next != null) {
			len++;
			node = node.next;
		}
		ListNode lastNode = node;

        k = k%len;
        if( len < 2 || k == 0)
        	return head;

        // Move 'len-k'
        node = head;
        int counter = 1;
        while(counter < len-k) { 
        	node = node.next;
        	counter++;
        }
        
        ListNode newHead = node.next;
        node.next = null;
        lastNode.next = head;
        
		return newHead;
    }
}
