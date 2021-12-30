package com.kausha.algo.leetcode.ds;


// https://leetcode.com/problems/linked-list-cycle-ii/
public class DetectCycleLinkedList2 {

	public static void main(String[] args) {
		DetectCycleLinkedList2 dc = new DetectCycleLinkedList2();
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(0);
		ListNode n4 = new ListNode(-4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;
		System.out.println(dc.detectCycle(n1).val);

	}

	public ListNode detectCycle(ListNode head) {
		
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				break;
			}
		}
		
		// If we reached the end, then there is no loop.
		if(fast == null || fast.next == null)
			return null;
		
		// Now 
        //return cycle;
		return null;
    }
}
