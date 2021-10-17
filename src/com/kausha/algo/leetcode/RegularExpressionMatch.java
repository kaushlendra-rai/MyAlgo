package com.kausha.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/regular-expression-matching/
/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input: s = "aab", p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:

Input: s = "mississippi", p = "mis*is*p*."
Output: false
 
 
 * @author sinkar
 *
 */
public class RegularExpressionMatch {

	public static void main(String[] args) {
		RegularExpressionMatch matcher = new RegularExpressionMatch();
		String str = "aab"; // True
		String pattern = "c*a*b";
//		String str = "mississippi"; // False
//		String pattern = "mis*is*p*.";
//		String str = "aaa"; // Should be false
//		String pattern = "ab*a";
//		String str = "aa"; // True
//		String pattern = "a*";
//		String str = "aa"; // True
//		String pattern = "ab*a*";
//		String str = "aa"; // True
//		String pattern = ".*";
//		String str = "aaa"; // True
//		String pattern = ".*";
//		String str = "aaa"; // True
//		String pattern = "ab*a*c*a";
		
//		String str = "aaba"; // False
//		String pattern = "ab*a*c*a";
		
		//String str = ""; // True
		//String pattern = "c*";
//		String str = "a"; // False
//		String pattern = ".*..a*";
//		String pattern = "ab*a";
//		String str = "a"; // False
		System.out.println(matcher.isMatch(str, pattern));
		System.out.println(matcher.isMatch_recursive(str, pattern));
	}

	public boolean isMatch(String str, String pattern) {
		if(str == null || pattern == null)
			return false;
		
		boolean[][] match = new boolean[str.length() + 1][pattern.length() + 1];
		// An empty string matches an empty expression.
		match[0][0] = true;
		
		// Handling the first row match for '.*'
		for(int i=1; i <  pattern.length()+1; i++) {
			if(pattern.charAt(i-1) == '*')
				match[0][i] = match[0][i-2];
		}
		for(int i = 1; i < str.length() + 1; i++) {
			for(int j=1; j <  pattern.length()+1; j++) {
				if(pattern.charAt(j-1) == '.' || pattern.charAt(j-1) == str.charAt(i-1)) {
					if(j-2 > 0 && pattern.charAt(j-2) == '*')
						match[i][j] = match[i-1][j-1] || match[i-1][j-3];
					else
						match[i][j] = match[i-1][j-1];
				}else if(pattern.charAt(j-1) == '*') {
					// For the wild card, we check if the match exists with the character before '*' or even without it.
					match[i][j] = match[i][j-2] || match[i][j-1];
					if(pattern.charAt(j-2) == str.charAt(i-1) || pattern.charAt(j-2) == '.')
						match[i][j] = match[i][j] || match[i-1][j-1] || match[i-1][j];
				}else
					match[i][j] = false;
			}
		}
		
		return match[str.length()][pattern.length()];
    }
	
	// Recursive solution
	public boolean isMatch_recursive(String str, String pattern) {
		if(pattern.isEmpty())
			return str.isEmpty();
		
		boolean firstMatch = !str.isEmpty() && (str.charAt(0) == pattern.charAt(0) || '.' == pattern.charAt(0));
		if(pattern.length() > 1 && '*' == pattern.charAt(1)){
			return (firstMatch && isMatch_recursive(str.substring(1), pattern)) || // Pattern matched teh current string.
					isMatch_recursive(str, pattern.substring(2)); // Substring from '2' because we need to skip char along with the '*'.
		}else if (firstMatch)
			return isMatch_recursive(str.substring(1), pattern.substring(1));
		
		return false;
	}
	
	// Memozation with recursion
	public boolean isMatch_Memo(String str, String pattern) {
		Map<String, Boolean> memo = new HashMap<>();
		return isMatch_Memo(str, pattern, memo);
	}
	public boolean isMatch_Memo(String str, String pattern, Map<String, Boolean> memo) {
		String key = str + "-" + pattern;
		if(memo.containsKey(key))
			return memo.get(key);
		
		if(pattern.isEmpty())
			return str.isEmpty();
		
		boolean firstMatch = !str.isEmpty() && (str.charAt(0) == pattern.charAt(0) || '.' == pattern.charAt(0));
		boolean status = false;
		if(pattern.length() > 1 && '*' == pattern.charAt(1)){
			status = (firstMatch && isMatch(str.substring(1), pattern)) || // Pattern matched teh current string.
					isMatch(str, pattern.substring(2)); // Substring from '2' because we need to skip char along with the '*'.
		}else if (firstMatch)
			status = isMatch(str.substring(1), pattern.substring(1));
		
		memo.put(key, status);
		
		return status;
	}
}
 