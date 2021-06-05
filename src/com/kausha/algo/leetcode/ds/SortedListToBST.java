package com.kausha.algo.leetcode.ds;

// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
public class SortedListToBST {

	public static void main(String[] args) {
		SortedListToBST slb = new SortedListToBST();
//		ListNode head = new ListNode(-10);
//		ListNode node1 = new ListNode(-3);
//		ListNode node2 = new ListNode(0);
//		ListNode node3 = new ListNode(5);
//		ListNode node4 = new ListNode(9);
//		head.next = node1;
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
		
		ListNode head = new ListNode(1);
		ListNode b1 = new ListNode(3);
		head.next = b1;
		
		TreeNode node = slb.sortedListToBST(null);
		
		if(node == null)
			System.out.println("Node is null");
		else
			System.out.println(node.val);
	}
	
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null)
			return null;
		
		ListNode node = head;
		// Find the length of the LinkedList
		int length = 0;
		while(node != null) {
			length++;
			node = node.next;
		}			
		ListNode[] listNodeArr = new ListNode[1];
		listNodeArr[0] = head;
		// We need to maintain the reference of the 
        return sortedListToBST(listNodeArr, length);
    }
	
	private TreeNode sortedListToBST(ListNode[] listNodeArr, int start) {
		if(start <= 0)
			return null;
		
		TreeNode left = sortedListToBST(listNodeArr, start/2);
		ListNode head = listNodeArr[0];
		TreeNode node = new TreeNode(head.val);
		node.left = left;
		head = head.next;
		listNodeArr[0] = head;
		node.right = sortedListToBST(listNodeArr, start -1 - start/2);
		
        return node;
    }
}
