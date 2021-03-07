package com.kausha.algo.dp;

// https://www.youtube.com/watch?v=3ZDZ-N0EPV0&list=RDCMUCZLJf_R2sWyUtXSKiKlyvAw&index=12
public class DP_RegularExpressionMatcherLeetcodeOrGoogle {

	public static void main(String[] args) {
		//String expr = "x?y*z";
		//String expr = "x?y*";
		String expr = "";
		String str = "";
		//String str = "xaylmz";
		
		boolean matchFound = isMatch(str, expr);
		System.out.println("Match: " + matchFound);
	}

	/**
	 * match[0][0] = true because an empty string matches an empty expression.
	 * If expr == str or expr == '?', then match[i][j] = match[i-1][j-1]
	 * if expr == '*', then match[i][j] = match[i-1][j] || match[i][j-1]
	 * else match[i][j] = false
	 * 
	 * The value at the corner match[iMax][jMax] indicates the final match status.
	 * 
	 * @param str
	 * @param expr
	 * @return
	 */
	private static boolean isMatch(String str, String expr) {
		if(str == null || expr == null)
			return false;
		else if(str.length() == 0 && expr.length()==1 & "*".equals(expr))
			return true;
			
		boolean[][] match = new boolean[str.length() + 1][expr.length() + 1];
		// An empty string matches an empty expression.
		match[0][0] = true;
		
		for(int i=1; i <= str.length(); i++) {
			for(int j=1; j <= expr.length(); j++) {
				if(str.charAt(i-1) == expr.charAt(j-1) || expr.charAt(j-1) == '?')
					match[i][j] = match[i-1][j-1];
				else if (expr.charAt(j-1) == '*')
					match[i][j] = match[i-1][j] || match[i][j-1];
				else // We need not have this line because by default, all values are 'false' in boolean array.
					match[i][j] = false;
			}
		}
		
		return match[str.length()][expr.length()];
	}

}
