package com.kausha.algo.leetcode;

public class SwapNodesInLinkedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(9);
		ListNode l4 = new ListNode(14);
		ListNode l5 = new ListNode(16);
		ListNode l6 = new ListNode(18);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		ListNode l7 = new ListNode(20);
//		ListNode l8 = new ListNode(22);
//		ListNode l9 = new ListNode(24);
//		ListNode l10 = new ListNode(26);
		l6.next = l7;
//		l7.next = l8;
//		l8.next = l9;
//		l9.next = l10;
		
		//ListNode l8 = new ListNode(2);
		
		ListNode d1 = new ListNode(2);
		ListNode d2 = new ListNode(4);
		d1.next = d2;
		
		SwapNodesInLinkedList ll = new SwapNodesInLinkedList();
		ListNode result = ll.swapNodes(l1, 3);
		//ListNode result = ll.swapNodes(d1, 1);
		if(result == null)
			System.out.println("Resulting node is NULL");
		while(result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}

	}

	public ListNode swapNodes(ListNode head, int k) {
		ListNode node = head;
        
        int size = 0;
        //Find length of linked list
        while(node != null) {
        	size++;
        	node = node.next;
        }
        
        // If link list is of single node, return it
        if(size == 1)
        	return head;
        
        node = head;
        // Swap first and last nodes explicitly if that is the case.
        if(size == k || k == 1) {
        	for(int i = 0; i < size-2; i++)
        		node = node.next;
        	
        	ListNode temp = head.next;
        	ListNode lastNode = node.next;
        	head.next = null;
			if(size ==2) {
				lastNode.next = head;
			}else {
				node.next = head;
				lastNode.next = temp;
			}
        	
        	
        	return lastNode;
        }
        
        ListNode first = null;
        ListNode second = null;
        
        node = head;
        int largerIndex = 0;
        int smallerIndex = 0;
        if(k > size-k) {
        	largerIndex = k-2;
        	smallerIndex = size-k-1;
        }else {
        	largerIndex = size-k-1;
        	smallerIndex = k-2;
        }
        
        for(int i=0; i <= largerIndex; i++) {
        	if(i == smallerIndex)
        		first = node;
        	if(i == largerIndex)
        		second = node;
        	
        	node = node.next;
        }
        
        // Lets swap first & second node's next values.
        ListNode f1 = first.next;
        ListNode f2 = first.next.next;
        
        ListNode s1 = second.next;
        ListNode s2 = second.next.next;
        
        first.next = s1;
        f1.next = s2;
        
        // Special handling for case where we swap adjacent numbers. 
        if(size%2 == 0 && (k*2 == size || (k-1)*2 == size)) {
        	s1.next = f1;
        }else {
        	s1.next = f2;
            second.next = f1;
        	
        }
        
		return head;
    }
}
