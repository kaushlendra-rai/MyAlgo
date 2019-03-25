package com.kausha.algo;

/**
 * Another way is iterative:
 * http://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
 * 
 * @author sinkar
 *
 */
public class LargestPalindrome {

	public static void main(String[] args) {
		//String str = "abcbad";
		String str = "azzzbcdedcb";
		//String str = "abccbaabcddcba";
		System.out.println("Original Str =  " + str);
		System.out.println("Largest Palindrome = " + getLargestPalindrome(str));

	}

	private static String getLargestPalindrome(String str){
		String palindrome = null;
		
		if(str == null || str.trim().length() == 0)
			return null;
		
		if(str.trim().length() == 1)
			return str;
		
		palindrome = str.substring(0, 1);
		
		for(int i=0; i<str.length(); i++){
			String evenPalindrome = expandPalindrome(str, i, i+1);
			String oddPalindrome = expandPalindrome(str, i-1, i+1);
			
			if(evenPalindrome != null && evenPalindrome.length() > palindrome.length())
				palindrome = evenPalindrome;
			
			if(oddPalindrome != null && oddPalindrome.length() > palindrome.length())
				palindrome = oddPalindrome;
		}
		
		return palindrome;
	}

	private static String expandPalindrome(String str, int start, int end) {
		if(start < 0 || end >= str.length())
			return null;
		
		String palindrome = null;
		
		if(str.charAt(start) == str.charAt(end)){
			palindrome = str.substring(start, end+1);
			String newPalindrome = expandPalindrome(str, start-1, end+1);
			
			if(newPalindrome != null)
				palindrome = newPalindrome;
		}
		
		return palindrome;
	}
}