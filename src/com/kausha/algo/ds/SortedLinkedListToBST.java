package com.kausha.algo.ds;


// http://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
public class SortedLinkedListToBST {
	public static void main(String[] args) throws Exception{
		LinkedListNode linkedListNode = DSUtil.generateNumericLinkedList();
		TreeNode root = linkedListToBST(linkedListNode);
		System.out.println("root.value = " + root.value);
	}

	private static TreeNode linkedListToBST(LinkedListNode start) throws Exception{
		if(start == null)
			return null;
		
		LinkedListNode node = start;
		int lengthOfDLL = 0;
		while(node != null){
			node = node.next;
			lengthOfDLL++;
		}

		Object[] refNode = new Object[1];
		refNode[0] = start;
	
		return convertDLLToBST(refNode, lengthOfDLL);
	}

	private static TreeNode convertDLLToBST(Object[] refNode, int lengthOfDLL) throws Exception{
		if(lengthOfDLL <= 0)
			return null;
		
		TreeNode left = convertDLLToBST(refNode, lengthOfDLL/2);
		
		LinkedListNode node = (LinkedListNode)refNode[0];
		TreeNode root = new TreeNode(Integer.parseInt(node.data));
		node = node.next;
		refNode[0] = node;
		
		root.left = left;
		root.right = convertDLLToBST(refNode, lengthOfDLL - lengthOfDLL/2 -1);
		
		return root;
	}
}