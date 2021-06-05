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
		String expr = ")()()(()))()(()()())(";
		//String expr = "(()(((()";
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
					stack.push(i);
			}
		}
		return longest;
	}
	public int longestValidParentheses_my(String s) {
		if(s == null)
			return -1;
		int longest = 0;
		int longestLocal = 0;
		int validCounter = 0;
		int length = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {
				validCounter++;
			}else {
				validCounter--;
				if(validCounter < 0) {
					if(longestLocal > longest)
						longest = longestLocal;

					length = 0;
					validCounter = 0;
					longestLocal = 0;
				}else  if (validCounter == 0){
					length+=2;
					longestLocal += length;
					length=0;
				}else {
					length+=2;
				}
			}
		}

		System.out.println("longest: " + longest + ", longestLocal: " + longestLocal + " , length : " + length);
		if(longest < longestLocal)
			longest = longestLocal;
		if(longest < length)
			longest = length;
		
		return longest;
    }
}
