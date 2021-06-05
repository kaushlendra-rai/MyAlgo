package com.kausha.algo.leetcode;

import java.util.Stack;

public class MinStackTest {

	public static void main(String[] args) {
//		MinStack  ms = new MinStack();
//		ms.push(-2);
//		ms.push(0);
//		ms.push(-3);
//		System.out.println(ms.getMin());
//		ms.pop();
//		System.out.println(ms.top());
//		System.out.println(ms.getMin());
		
		MinStack  ms = new MinStack();
		ms.push(-2);
		ms.push(0);
		ms.push(-1);
		System.out.println(ms.getMin());
		System.out.println(ms.top());
		ms.pop();
		System.out.println(ms.getMin());
	}

}

class MinStack {

	Stack<Integer> stack;
	Stack<Integer> minVals;
	
    /** initialize your data structure here. */
    public MinStack() {
    	stack = new Stack<>();
    	minVals = new Stack<>();
    }
    
    public void push(int val) {
        if(minVals.isEmpty() || minVals.peek() > val)
        	minVals.push(val);
        else if(stack.peek() > val && val == minVals.peek())
        	minVals.push(val);
        stack.push(val);
    }
    
    public void pop() {
        int num = stack.pop();
        if(stack.isEmpty())
        	minVals.pop();
        else if(num != stack.peek() && num == minVals.peek())
        	minVals.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minVals.peek();
    }
}