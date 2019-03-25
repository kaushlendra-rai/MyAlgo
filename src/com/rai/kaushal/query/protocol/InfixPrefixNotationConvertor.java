package com.rai.kaushal.query.protocol;

import java.util.Stack;

public class InfixPrefixNotationConvertor {

	public static void main(String[] args) {
		String infixQuery = "AND(OR(sastype EQ Report.BI) OR(sasowner EQ sasadm)) AND(sastype EQ StoredProcess) NOT(dataitem EQ type)";
		
		//String infixQueryTemp = "((sastype EQ Report.BI) OR (sasowner EQ sasadm)) AND (sastype EQ StoredProcess) NOT(dataitem EQ type)";
		
		
		String infixQueryTemp = "AND(IN(sastype, Report.BI, StoredProcess), IN(sasowner, sasadm, sassearch), LTEQ(creationdate, 1111), GTEQ(creationdate, 3333))";

		
		String preFixQuery = convertInfixToPrefixNotation(infixQuery);
	}
	
	private static String convertPrefixToInfixNotation(String filter){
		StringBuilder result = new StringBuilder();
		
		
		return result.toString();
	}
	
	private static String convertInfixToPrefixNotation(String filter){
		StringBuilder result = new StringBuilder();
		
		Stack<String> stack = new Stack<String>();
		
		return result.toString();
	}
}