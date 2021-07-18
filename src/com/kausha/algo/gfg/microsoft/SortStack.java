package com.kausha.algo.gfg.microsoft;

import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/sort-a-stack/1/?company[]=Microsoft&company[]=Microsoft&page=2&query=company[]Microsoftpage2company[]Microsoft

public class SortStack {

	public static void main(String[] args) {
		SortStack ss = new SortStack();
		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(4);
//		stack.push(2);
//		stack.push(3);
		
//		stack.push(11);
//		stack.push(2);
//		stack.push(32);
//		stack.push(3);
//		stack.push(41);
		
		System.out.println("Input: " + stack);
		System.out.println("Output: " + ss.sort(stack));
	}

	public Stack<Integer> sort(Stack<Integer> s)
	{
		// We push the smallest number to the bottom recursively.
		for(int i=0; i < s.size(); i++) {
			moveSmallest(s, s.pop(), s.size() - i);
		}
		return s;
	}
	
	private void moveSmallest(Stack<Integer> s, int num, int counter) {
		if(counter <= 0) {
			s.push(num);
			return;
		}
		int larger = num;
		int stackNum = s.pop();
		if(stackNum < num) {
			moveSmallest(s, stackNum, counter-1);
		}else {
			larger = stackNum;
			moveSmallest(s, num, counter-1);
		}
		
		s.push(larger);
	}
}
