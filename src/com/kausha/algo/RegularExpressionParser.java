package com.kausha.algo;

public class RegularExpressionParser {
	public static void main(String[] args) {
		String str = "sample";
		String expr = "*sam*l**";
		boolean status = parseExpression(str, expr);
		System.out.println("Status = " + status);
		
		System.out.println("2 ****" + isMatch(str, expr));
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
	
	//  Not working as expected for my expression.
	// ##############################################
	public static boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}