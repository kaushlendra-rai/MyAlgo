package com.kausha.algo;

import java.util.Stack;

public class RemovedUnbalancedParanthesis {
	public static void main(String[] args) {
		//String expr = ")((())))";
		//String expr = "(())(())";
		String expr = "(())(())))";
		System.out.println("Braces to be removed = " + removeInvalidraces(expr));
	}

	private static String removeInvalidraces(String expr) {
		
		Stack<Integer> start = new Stack<Integer>();
		Stack<Integer> end = new Stack<Integer>();
		
		int balancer = 0;
		
		for(int i=0; i < expr.length(); i++){
			if(expr.charAt(i) == '('){
				start.push(i);
				balancer++;
			}else if(expr.charAt(i) == ')' && balancer >0){
				start.pop();
				balancer--;		
			}else{
				end.push(i);
			}
		}
		
		start.addAll(end);
		
		// Remove elements from Expr that exists in stack
		StringBuilder finalExpr = new StringBuilder();
		for(int i=0; i < expr.length(); i++){
			if(!start.contains(i))
				finalExpr.append(expr.charAt(i));
		}
		
		return finalExpr.toString();
	}
}