package com.kausha.algo.leetcode.ds;

// https://leetcode.com/problems/reverse-linked-list-ii/
/**
 * Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 * @author sinkar
 *
 */
public class ReverseLinkedListWithinRange {

	public static void main(String[] args) {
		

	}

	//First traverse upto start node.
	// Then reverse the node from start to end iteratively.
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode root = head;
		if(left == right)
			return head;
		
		//Handle case where reversal begins from the start of the node
		for(int i=0; i < left-1; i++)
				root = root.next;
		
		// reverse 
        return null;
    }
}

class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }