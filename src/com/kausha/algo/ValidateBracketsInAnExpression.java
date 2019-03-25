package com.kausha.algo;

public class ValidateBracketsInAnExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String expr = ")((()))(";

		System.out.println(expr);
		
		System.out.println("Is Valid Expression = " + validateExpression(expr));
	}

	private static boolean validateExpression(String expr){
		boolean isValid = false;
		int bracketCounter = 0;
		
		for(int i=0; i < expr.length(); i++){
			if(bracketCounter < 0)
				break;
			else if('(' == expr.charAt(i))
				bracketCounter++;
			else if(')' == expr.charAt(i))
				bracketCounter--;
		}
		
		if(bracketCounter == 0)
			isValid = true;
		
		return isValid;
	}
}