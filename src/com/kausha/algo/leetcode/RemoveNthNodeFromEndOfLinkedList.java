package com.kausha.algo.leetcode;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
public class RemoveNthNodeFromEndOfLinkedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(9);
		ListNode l4 = new ListNode(14);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;

		ListNode l8 = new ListNode(2);
		
		RemoveNthNodeFromEndOfLinkedList ll = new RemoveNthNodeFromEndOfLinkedList();
		ListNode result = ll.removeNthFromEnd(l8, 1);
		if(result == null)
			System.out.println("Resulting node is NULL");
		while(result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        
        int size = 0;
        //Find length of linked list
        while(node != null) {
        	size++;
        	node = node.next;
        }
        // Delete the head node.
        if(size-n == 0)
        	return head.next;
        
        node = head;
        for(int i=0; i < size-n-1; i++) {
        	node = node.next;
        }
        // Delete last node.
        if(n == 1)
        	node.next = null;
        else
        	node.next = node.next.next;
        
		return head;
    }
}
