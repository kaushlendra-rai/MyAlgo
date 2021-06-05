package com.kausha.algo;

// https://www.youtube.com/watch?v=qQ8vS2btsxI
public class SearchSubString_RabinKarp {
    // Program to implement the KMP algorithm in Java
    public static void main(String[] args)    {
        String text = "ABCABAABCABAC";
        String pattern = "CAB";
 
        System.out.println(rabinKarp(text, pattern));
    }

	private static boolean rabinKarp(String text, String pattern) {
		double patternHash = calculateHash(pattern);
		double textHash = calculateHash(text.substring(0, pattern.length()));
		
		if(patternHash == textHash && stringsMatch(pattern, text, 0))
			return true;
		int startIdx = 0;
		for(int i=pattern.length(); i < text.length(); i++) {
			textHash = 26*(textHash - (text.charAt(startIdx)-'A') * Math.pow(26, pattern.length()-1)) + (text.charAt(i)-'A');
			// Since we are now calculating next hash, the string comparision should be from 'startIdx+1'.
			if(patternHash == textHash && stringsMatch(pattern, text, startIdx+1))
				return true;
			startIdx++;
		}
		
		return false;
	}
    
	private static double calculateHash(String str) {
		double hash=0;
		for(int i=0; i< str.length(); i++) {
			hash += (str.charAt(i)-'A') * Math.pow(26, str.length()-1-i);
			// There is a possibility of the value exceeding long limits for large strings. Hence take modulo
			// for Integer's MAX.
			hash = hash%Integer.MAX_VALUE;
		}
		
		return hash;
	}
	
	private static boolean stringsMatch(String pattern, String text, int startIdx) {
		for(int i=0; i< pattern.length(); i++) {
			if (pattern.charAt(i) != text.charAt(startIdx + i))
				return false;
		}
		return true;
	}
}
