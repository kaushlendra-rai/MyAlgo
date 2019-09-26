package com.kausha.algo.ds;

public class LinkedListBasedPalindromeValidationRecursive {
	public static void main(String[] args) {
		//LinkedListNode node = DSUtil.generateLinkedList();
		LinkedListNode node = DSUtil.generatePalindromeLinkedList();
		
		boolean isPalindrome = validatePalindromeInLinkedList(node);
		System.out.println("isPalindrome = " + isPalindrome);
	}
	
	private static boolean validatePalindromeInLinkedList(LinkedListNode node){
		if(validatePalindrome(node, node) != null)
			return true;
		else
			return false;
	}
	
	private static LinkedListNode validatePalindrome(LinkedListNode node1,	LinkedListNode node2) {
		if(node1 == null)
			return node2;
		
		LinkedListNode tempNode = validatePalindrome(node1.next, node2);
		
		if(tempNode == null)
			return null;
		
		if(tempNode.data.equals(node1.data)){
			// In case of complete match, we will reach null eventually on both list.
			// However, in order to distinguish between failure and success, we keep success as non-null.
			if(tempNode.next == null)
				return tempNode;
			else
				return tempNode.next;
		}else
			return null;
	}
}