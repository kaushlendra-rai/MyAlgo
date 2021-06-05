package com.kausha.algo.leetcode.ds;

// https://leetcode.com/problems/palindrome-linked-list/
public class IsPalindromeLinkedList {

	public static void main(String[] args) {
		IsPalindromeLinkedList ip = new IsPalindromeLinkedList();
//		ListNode head = new ListNode(3);
//		ListNode node1 = new ListNode(4);
//		ListNode node2 = new ListNode(5);
//		ListNode node22 = new ListNode(5);
//		ListNode node3 = new ListNode(4);
//		ListNode node4 = new ListNode(3);
//		head.next = node1;
//		node1.next = node2;
//		node2.next = node22;
//		node22.next = node3;
//		node3.next = node4;
		
//		ListNode head = new ListNode(3);
//		ListNode node1 = new ListNode(4);
//		head.next = node1;
		
//		ListNode head = new ListNode(3);
//		ListNode node1 = new ListNode(3);
//		head.next = node1;
		
		ListNode head = new ListNode(3);
		
		System.out.println(ip.isPalindrome(head));
	}

	public boolean isPalindrome(ListNode head) {
		ListNode node = head;
		int length = 0;
		while(node != null) {
			length++;
			node = node.next;
		}
		if(length == 1)
			return true;
		
		boolean[] status = new boolean[] {true};
		
        isPalindrome(head, head, status, 0, length);
        return status[0];
    }
	
	private ListNode isPalindrome(ListNode head, ListNode runner, boolean[] status, int idx, int length) {
		ListNode temp = null;
		if(idx < length/2)
			temp = isPalindrome(head.next, runner.next, status, idx+1, length);

		if(idx == length/2 && length%2 == 1)
			return runner.next;
		else if(idx == length/2 && length%2 == 0)
			return runner;
		
		if(status[0] == false || head.val != temp.val) {
			status[0] = false;
			return null;
		}
        return temp.next;
    }
}
