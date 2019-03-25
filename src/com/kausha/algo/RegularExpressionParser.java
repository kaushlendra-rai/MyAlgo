package com.kausha.algo;

public class RegularExpressionParser {
	public static void main(String[] args) {
		String str = "sample";
		String expr = "*sam*l**";
		int strIndex = 0;
		int exprIndex = 0;
		boolean status = parseExpression(str, expr);
		System.out.println("Status = " + status);
	}
	
	private static boolean parseExpression(String str, String expr) {
		int strIndex = 0;
		int exprIndex = 0;
		
		// Remove any extra '*' (more than 1) from end of expr
		
		if(expr.charAt(expr.length()-1) == '*'){
			for(int i = expr.length()-2; i >=0; i--)
				if(expr.charAt(i) != '*'){
					expr = expr.substring(0, i+1) + "*";
					break;
				}
			System.out.println("processed expr = " + expr);
		}
		
		return parseExpression(str, expr, strIndex, exprIndex);
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