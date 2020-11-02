package com.kausha.algo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class PrintAllCombinationOfBrackets {
	public static void main(String[] args) {
		generateBracketCombinations(3);
	}

	private static void generateBracketCombinations(int bracketCount) {
		generateBracketCombinations("", bracketCount, bracketCount);
	}

	private static void generateBracketCombinations(String string, int leftBracketCount, int rightBracketCount) {
		if (leftBracketCount == 0 && rightBracketCount == 0) {
			System.out.println(string);
			return;
		}
		
		if(leftBracketCount > 0)
			generateBracketCombinations(string + "(", leftBracketCount-1, rightBracketCount);

		if(rightBracketCount > leftBracketCount)
			generateBracketCombinations(string + ")", leftBracketCount, rightBracketCount-1);
	}
}