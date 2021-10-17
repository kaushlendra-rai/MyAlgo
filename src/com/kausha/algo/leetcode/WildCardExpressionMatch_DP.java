package com.kausha.algo.leetcode;

// https://leetcode.com/problems/wildcard-matching/
/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input: s = "adceb", p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input: s = "acdcb", p = "a*c?b"
Output: false
 * @author sinkar
 *
 */
public class WildCardExpressionMatch_DP {

	public static void main(String[] args) {
//		String str = "xaylmz";
//		//String expr = "x?y*z";
//		String expr = "x?y*";

//		String str = "";
//		String expr = "";

		String str = "";
		String expr = "***";
		
//		String str = "acdcb";
//		String expr = "a*c?b";
		
		WildCardExpressionMatch_DP match = new WildCardExpressionMatch_DP();
		boolean matchFound = match.isMatch(str, expr);
		System.out.println("Match: " + matchFound);

	}
	
	public boolean isMatch(String s, String p) {
		if(s== null || p == null)
			return false;
		
		boolean[][] match = new boolean[s.length()+1][p.length()+1];
		// Empty string matches empty expression.
		match[0][0] = true;
		// populate first row at index '0'. // Edge case for s="" & p="*****" which should return 'true'.
		for(int i=1; i<= p.length(); i++)
			if(p.charAt(i-1) == '*')
				match[0][i]=match[0][i-1];
		
		for(int i = 1; i <= s.length(); i++) {
			for(int j=1; j <= p.length(); j++) {
				if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
					match[i][j] = match[i-1][j-1];
				}else if(p.charAt(j-1) == '*') {
					match[i][j] = match[i-1][j] || match[i][j-1];
				}else
					match[i][j] = false;
			}
		}
		
		return match[s.length()][p.length()];
    }
}
