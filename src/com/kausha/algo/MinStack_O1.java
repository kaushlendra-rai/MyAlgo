package com.kausha.algo;

import java.util.Stack;

// Implement stack to fetch minimum number at O(1) time. 
public class MinStack_O1 {

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(3);
		stack.push(5);
		stack.push(7);
		stack.push(1);
		
		System.out.println("Min: " + stack.min);
		
		stack.pop();
		System.out.println("After popMin: " + stack.min);
		
		System.out.println("****************************************************************");
		MinStack_M1 stack2 = new MinStack_M1();
		stack2.push(3);
		stack2.push(5);
		stack2.push(7);
		stack2.push(1);
		
		System.out.println("Min: " + stack2.min);
		
		stack2.pop();
		System.out.println("After popMin: " + stack2.min);
	}

}

//O(1) With O(1) Space
class MinStack_M1{
	public Stack<Integer> stack = new Stack<Integer>();
	int min;
	
	public void push(Integer num) {
		if(stack.size() == 0){
			// First number in stack
			stack.push(num);
			min = num;
		}else if(min > num){
			// We have a new min
			stack.push(2*num - min);
			min = num;
		}else {
			stack.push(num);
		}
	}
	
	public Integer pop() {
		int popValue = min;
		int num = stack.pop();
		if(num < min) 
			min = 2*min - num;
		
		return popValue;
	}
	
	// Returns Integer.MIN in case of empty stack;
	public Integer min() {
		if(stack.size() == 0)
			return Integer.MIN_VALUE;
		
		return min;
	}
}

// O(1) With Extra Space
class MinStack{
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	int min = Integer.MAX_VALUE;
	
	public void push(Integer num) {
		stack.push(num);
		if(num < min) {
			minStack.push(num);
			min = num;
		}else
			minStack.push(min);
	}
	
	public Integer pop() {
		minStack.pop();
		min = minStack.peek();
		return stack.pop();
	}
	
	public Integer min() {
		return stack.peek();
	}
}