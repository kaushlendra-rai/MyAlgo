package com.kausha.algo.ds;

// This approach works only if we are allowed to change the internal sequence of the linked list.
public class LinkedListBasedPalindromeValidationIterative {
	public static void main(String[] args) {
		LinkedListNode node = DSUtil.generateLinkedList();
		
		boolean isPalindrome = validatePalindromeInLinkedListIterative(node);
		System.out.println("isPalindrome = " + isPalindrome);
	}

	private static boolean validatePalindromeInLinkedListIterative(LinkedListNode node) {
		// Reverse the DLL half way and then compare 0 with (N/2 + 1) & so on
		LinkedListNode lengthNode = node;
		// Find length of the LinkedList
		int length = 0;
		while(lengthNode != null){
			length++;
			lengthNode = lengthNode.next;
		}
		
		// Iteratively reverse the LinkedList
		LinkedListNode firstNode = node;
		int counter = 0;
		while(node.next != null && counter < (length/2)-1){
			LinkedListNode temp1 = node.next.next;
			LinkedListNode temp = node.next;
			temp.next = firstNode;
			
			node.next = temp1;
			firstNode = temp;
			counter++;
		}
		
		//Ensure that you skip the central node from reversal if the list is odd sized. 
		if(length%2 == 0)
			node = node.next;
		else
			node = node.next.next;
		
		// Compare the node values.
		while(node != null){
			if(node.data == firstNode.data){
				node = node.next;
				firstNode = firstNode.next;
			}else
				return false;
		}
		
		return true;
	}
}