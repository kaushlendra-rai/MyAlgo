package com.kausha.algo.leetcode;

// https://leetcode.com/problems/break-a-palindrome/
/**
 * Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.
Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.

A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.
Example 1:

Input: palindrome = "abccba"
Output: "aaccba"
Explanation: There are many ways to make "abccba" not a palindrome, such as "zbccba", "aaccba", and "abacba".
Of all the ways, "aaccba" is the lexicographically smallest.
Example 2:

Input: palindrome = "a"
Output: ""
Explanation: There is no way to replace a single character to make "a" not a palindrome, so return an empty string.
Example 3:

Input: palindrome = "aa"
Output: "ab"
Example 4:

Input: palindrome = "aba"
Output: "abb"
*/
public class BreakAPalindromeLeetCode {

	public static void main(String[] args) {
		//System.out.println(breakPalindrome("bb"));
		//System.out.println(breakPalindrome("aaccaa")); // aaacaa
		//System.out.println(breakPalindrome("aabaa")); // aabab
		System.out.println(breakPalindrome("aaaaa")); // aaaab
	}

	public static String breakPalindrome(String str) {
		String brokenPalindrome = null;
		if(str == null ||  str.length() <2)
			return "";
		boolean oddCentrePassed = false;
		for(int i=1; i < str.length(); i++) {
			System.out.println("i:" + i);
			// switching any character at the center in odd length palindrome has no effect. It stays a plaindrome still.
			if(str.length()%2 == 1 && (str.length()/2) == i) {
				oddCentrePassed = true;
				System.out.println("Continue");
				continue;
			}else {
				if (!oddCentrePassed && str.charAt(i-1) != 'a') {
					System.out.println("12");
					brokenPalindrome = str.substring(0, i-1) + "a" + str.substring(i);
					break;
				}else if(str.charAt(i-1) == 'a'  && str.charAt(i) != 'a'){
					brokenPalindrome = str.substring(0, i) + "a" + str.substring(i+1);
					break;
				}else if(str.charAt(i) == 'a' || oddCentrePassed) {
					oddCentrePassed = false;
					continue;
				}
			}
		}
		
		// Replace the last character with 'b'. as we could not replace any character based on above conditions.
		if(brokenPalindrome == null) {
			brokenPalindrome = str.substring(0, str.length()-1) + "b";
			System.out.println("Inside");
		}
		return brokenPalindrome;
	}
}
