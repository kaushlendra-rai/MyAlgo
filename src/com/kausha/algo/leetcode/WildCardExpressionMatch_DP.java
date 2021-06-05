package com.kausha.algo.leetcode;

// https://leetcode.com/problems/wildcard-matching/
public class WildCardExpressionMatch_DP {

	public static void main(String[] args) {
//		String str = "xaylmz";
//		//String expr = "x?y*z";
//		String expr = "x?y*";

//		String str = "";
//		String expr = "";

//		String str = "";
//		String expr = "***";
		
		String str = "acdcb";
		String expr = "a*c?b";
		
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
		// populate first row at index '0'.
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
