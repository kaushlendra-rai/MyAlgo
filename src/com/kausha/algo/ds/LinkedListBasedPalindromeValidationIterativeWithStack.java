package com.kausha.algo.ds;

import java.util.Stack;

public class LinkedListBasedPalindromeValidationIterativeWithStack {
	public static void main(String[] args) {
		//LinkedListNode node = DSUtil.generateLinkedList();
		LinkedListNode node = DSUtil.generatePalindromeLinkedList();
		
		boolean isPalindrome = validatePalindromeInLinkedListIterative(node);
		System.out.println("isPalindrome = " + isPalindrome);
	}

	private static boolean validatePalindromeInLinkedListIterative(LinkedListNode node) {
		if(node == null || node.next == null)
			return true;
		
		Stack<LinkedListNode> stack = new Stack<LinkedListNode>();
		LinkedListNode temp = node;
		while(temp != null && temp.next != null) {
			stack.push(node);
			node = node.next;
			temp = temp.next.next;
		}
		
		//if(stack.size()%2 == 1)
		if(temp != null)
			node = node.next;
		
		while(node != null) {
			if (!node.data.equals(stack.pop().data))
				return false;
			else 
				node = node.next;
		}
		
		return true;
	}

	
}
