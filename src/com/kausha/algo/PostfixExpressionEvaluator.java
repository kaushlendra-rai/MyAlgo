package com.kausha.algo;

import java.util.Stack;


// http://www.careercup.com/question?id=5615459812507648
public class PostfixExpressionEvaluator {
	public static void main(String[] args) {
		String expr = "432+*";
		int value = evaluatePostfixExpr(expr);
		System.out.println("Expression value = " + value);
	}

	private static int evaluatePostfixExpr(String expr) {
		if(expr == null || expr.trim().length() == 0)
			return 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < expr.length(); i++){
			char c = expr.charAt(i);
			
			// Push the number to Stack
			if(c >= '0' && c <= '9'){
				stack.push((Integer) (c - '0'));
			}else if(c == '+' || c == '-' || c == '*' || c == '/'){
				int num1 = stack.pop();
				int num2 = stack.pop();
		System.out.println("num1 = " + num1 +   "    , num2 = " + num2 + "  , Operator = " + c);		
				switch(c){
				case '+': {
					stack.push(num1 + num2);
					break;
				}
				case '-': {
					stack.push(num1 - num2);
					break;
				}
				case '*': {
					stack.push(num1 * num2);
					break;
				}
				case '/': {
					stack.push(num1 / num2);
					break;
				}
				default : System.out.println("Inside Default   c =  " + c);
				}
			}else{
				throw new RuntimeException("Invalid expression character - " + c);
			}
		}
		
		return stack.pop();
	}
}