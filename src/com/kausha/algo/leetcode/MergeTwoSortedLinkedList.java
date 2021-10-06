package com.kausha.algo.leetcode;

// https://leetcode.com/problems/merge-two-sorted-lists/
/**
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by
 *  splicing together the nodes of the first two lists.
 *  
 * @author sinkar
 *
 */
public class MergeTwoSortedLinkedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(9);
		l1.next = l2;
		l2.next = l3;
		
		ListNode r1 = new ListNode(5);
		ListNode r2 = new ListNode(6);
		ListNode r3 = new ListNode(8);
		r1.next = r2;
		r2.next = r3;
		MergeTwoSortedLinkedList sll = new MergeTwoSortedLinkedList();
		
		//ListNode merged = sll.mergeTwoLists(l1, r1);
		
		ListNode merged = sll.mergeTwoLists(l1, r1);
		
		while(merged != null) {
			System.out.print(merged.val + " -> ");
			merged = merged.next;
		}
	}

	// Assuming that the list is sorted in increasing order.
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1== null)
        	return l2;
        if(l2 == null)
        	return l1;
        
        ListNode node = l1;
        if(l1.val > l2.val) {
        	node = l2;
        	l2 = l2.next;
        }else
        	l1 = l1.next;
        
        ListNode head = node;
        
        while(l1 != null && l2 != null) {
        	if(l1.val > l2.val) {
            	node.next = l2;
            	l2 = l2.next;
            }else {
            	node.next = l1;
            	l1 = l1.next;
            }
        	node = node.next;
        }
		
        if(l1 != null)
        	node.next = l1;
        else
        	node.next = l2;
        
        return head;
    }
}
