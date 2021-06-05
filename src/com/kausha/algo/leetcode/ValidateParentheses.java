package com.kausha.algo.leetcode;

import java.util.Stack;

//  https://leetcode.com/problems/valid-parentheses/
/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 * @author sinkar
 *
 */
public class ValidateParentheses {

	public static void main(String[] args) {
		ValidateParentheses validate = new ValidateParentheses();
		//String expr = "(([))]";
		//String expr = "()[]{}";
		//String expr = "([)]";
		String expr = "{[]}";
		//String expr = "";
		//String expr = ")";
		//String expr = "(";
		System.out.println(validate.isValid(expr));
	}

	public boolean isValid(String s) {
		if(s == null)
			return false;
	
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i < s.length(); i++) {
			char charAtI = s.charAt(i); 
			if(charAtI == '(' || charAtI == '{' || charAtI == '[') {
				stack.push(charAtI);
			}else {
				if(stack.isEmpty())
					return false;
				
				char exp = stack.pop();
				if((exp == '(' && charAtI != ')') || (exp == '{' && charAtI != '}') || (exp == '[' && charAtI != ']')) {
					return false;
				}
			}
		}
		
		if(stack.isEmpty())
			return true;
		
		return false;
    }
}
