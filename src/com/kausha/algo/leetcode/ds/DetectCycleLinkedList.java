package com.kausha.algo.leetcode.ds;


// https://leetcode.com/problems/linked-list-cycle/
public class DetectCycleLinkedList {

	public static void main(String[] args) {
		DetectCycleLinkedList dc = new DetectCycleLinkedList();
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(0);
		ListNode n4 = new ListNode(-4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;
		System.out.println(dc.hasCycle(n1));

	}

	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return true;
			}
		}
		
		return false;
    }
}
