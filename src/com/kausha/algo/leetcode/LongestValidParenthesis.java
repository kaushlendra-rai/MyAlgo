package com.kausha.algo.leetcode;

import java.util.Stack;

public class LongestValidParenthesis {

	public static void main(String[] args) {
		LongestValidParenthesis validate = new LongestValidParenthesis();
		//String expr = "";
		//String expr = ")";
		//String expr = "(";
		//String expr = "(()";
		//String expr = ")()())";

		//String expr = "))))((((";
		//String expr = "()(()";
		
		//String expr = "((((()";
		//String expr = "()((((()";
		
		//String expr = ")()())()()(";
		//String expr = ")()()(()))()(()()())(";
		String expr = "(()(((()";
		System.out.println(validate.longestValidParentheses(expr));
	}

	public int longestValidParentheses(String s) {
		if(s == null)
			return -1;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int longest = 0;
		
		for(int i=0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(i);
			}else {
				if(!stack.isEmpty())
					stack.pop();
				if(!stack.isEmpty())
					longest = longest > (i - stack.peek()) ? longest : (i - stack.peek());
				else
					stack.push(i);// This is for case where the invalid closing bracket is encountered.
			}
		}
		return longest;
	}
}
