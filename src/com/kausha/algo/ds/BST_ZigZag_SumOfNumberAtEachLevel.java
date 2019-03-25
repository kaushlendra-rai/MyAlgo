package com.kausha.algo.ds;

import java.util.Stack;



// http://www.careercup.com/question?id=5767618180939776
public class BST_ZigZag_SumOfNumberAtEachLevel {	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		TreeNode root = BSTFromSortedArray.createBSTFromSortedArray(arr);
		printSumOfNumbersAtEachLevel(root);
	}
	
	// tHE METHOD TRAVERSES THE TREE IN ZIG-ZAG FASHION
	public static void printSumOfNumbersAtEachLevel(TreeNode node){
		if(node == null)
			return;
		
		Stack<TreeNode> currentStack = new Stack<TreeNode>();
		Stack<TreeNode> childrenStack = new Stack<TreeNode>();
		
		currentStack.push(node);
		
		printSumOfNumbersAtEachLevel(currentStack, childrenStack);
	}
	
	private static void printSumOfNumbersAtEachLevel(Stack<TreeNode> currentStack, Stack<TreeNode> childrenStack){
		int sum =0;
		System.out.println("");
		while(!currentStack.isEmpty()){
			TreeNode cNode = currentStack.pop();
			
			sum += cNode.value;
			System.out.print(cNode.value + "   ");
			if(cNode.left != null)
				childrenStack.push(cNode.left);
			
			if(cNode.right != null)
				childrenStack.push(cNode.right);
		}
		
		System.out.println(" SUM = " + sum);
		
		if(!childrenStack.isEmpty())
			printSumOfNumbersAtEachLevel(childrenStack, currentStack);
	}
}