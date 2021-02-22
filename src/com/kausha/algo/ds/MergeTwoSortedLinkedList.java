package com.kausha.algo.ds;

public class MergeTwoSortedLinkedList {
	public static void main(String[] args) {
		LinkedListNode list1 = DSUtil.generateSortedIntegerLinkedList1();
		LinkedListNode list2 = DSUtil.generateSortedIntegerLinkedList2();
		
		LinkedListNode mergedList = mergeSortedLists(list1, list2);
		
		System.out.println("Merged list:");
		while(mergedList != null) {
			System.out.print(mergedList.num + " ");
			mergedList = mergedList.next;
		}
	}

	// We maintain the head pointer and merge the lists
	private static LinkedListNode mergeSortedLists(LinkedListNode list1, LinkedListNode list2) {
		if(list1 == null)
			return list2;
		else if(list2 == null)
			return list1;
		
		LinkedListNode head = null;
		LinkedListNode sortedList = null;
		if(list1.num < list2.num)
			head = list1;
		else
			head = list2;
		
		while(list1 != null && list2 != null) {
			if(list1.num < list2.num) {
				if(sortedList == null)
					sortedList = list1;
				else {
					sortedList.next = list1;
					sortedList = sortedList.next;
				}
				list1 = list1.next;	
			}else {
				if(sortedList == null)
					sortedList = list2;
				else {
					sortedList.next = list2;
					sortedList = sortedList.next;
				}
				list2 = list2.next;
			}
		}
		
		// We append the trailing non-null linked list to the sorted merged list
		if(list1 != null)
			sortedList.next = list1;
		else 
			sortedList.next = list2;
		
		return head;
	}
}