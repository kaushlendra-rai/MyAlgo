package com.kausha.algo.ds;

public class RegularExpressionParser {
	public static void main(String[] args) {
		String str = "sample";
		String expr = "*sam*le";
		boolean status = parseExpression(str, expr, 0, 0);
		System.out.println("Status = " + status);
	}

	private static boolean parseExpression(String str, String expr, int strIndex, int exprIndex) {
		//Terminal Condition
		if(strIndex >= str.length() || exprIndex >= expr.length())
			return false;
		
		char strChar = str.charAt(strIndex);
		char exprChar = expr.charAt(exprIndex);
		
		if(strIndex == str.length()-1 && exprIndex == expr.length()-1){
			if(exprChar == '*' || exprChar == '?' || exprChar == strChar)
				return true;
			else
				return false;
		}
		
		if(exprChar == '*'){
			return parseExpression(str, expr, strIndex, exprIndex + 1) | 
					parseExpression(str, expr, strIndex + 1, exprIndex + 1) |
					parseExpression(str, expr, strIndex + 1, exprIndex);
			
		}else if(exprChar == '?' || exprChar == strChar){
			return parseExpression(str, expr, strIndex + 1, exprIndex + 1);
		}else{
			return false;
		}
	}
}