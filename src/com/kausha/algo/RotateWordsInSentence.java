package com.kausha.algo;

public class RotateWordsInSentence {

	public static void main(String[] args) {
		StringBuilder input = new StringBuilder(" My name is Kaushal ");
		System.out.println("Original word:" + input);
		System.out.println("Reversed by Words:" + rotateWordsInSentence(input)); // Expected: "Kaushal is name My"
	}
	
	private static StringBuilder rotateWordsInSentence(StringBuilder str) {
		int wordStartIndex = 0;
		int wordEndIndex = 1;
		while(wordStartIndex < str.length()-1) {
			wordEndIndex = findWordBoundary(str, wordStartIndex);
			reverseWord(str, wordStartIndex, wordEndIndex);
			wordStartIndex = wordEndIndex+1;
		}
		
		reverseWord(str, 0, str.length());  // Now reverse the whole sentence of reversed words: yM eman si  lahsuaK
		
		return str;
	}

	private static int findWordBoundary(StringBuilder str, int startIndex) {
		for(int i=startIndex; i < str.length(); i++) 
				if(' ' == str.charAt(i))
					return i;
		
		return str.length();
	}
	
	private static void reverseWord(StringBuilder str, int startIndex, int endIndex) {
		// If an empty space is at the start of word, endIndex becomes '0'. and --endIndex below becomes -1 ... which is not a valid Index, hence adjustment
		if(endIndex == 0)
			endIndex = 1;
		
		int end = --endIndex; // Remove the last extra trailing 1 index of space
		
		for(int i= startIndex; i <= startIndex + (end-startIndex)/2; i++) {
			char temp = str.charAt(i);
			str.setCharAt(i, str.charAt(endIndex));
			str.setCharAt(endIndex, temp);
			endIndex--;
		}
	}
}