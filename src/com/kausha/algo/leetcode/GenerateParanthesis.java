package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]

 * @author sinkar
 *
 */
public class GenerateParanthesis {

	public static void main(String[] args) {
		GenerateParanthesis paren = new GenerateParanthesis();
		
		System.out.println(paren.generateParenthesis(3));

	}

	public List<String> generateParenthesis(int n) {
        List<String> parenthesisList = new ArrayList<>();
        if(n > 0)
        	generateParenthesis(parenthesisList, "", n, n);
		return parenthesisList;
    }
	
	private void generateParenthesis(List<String> parenthesisList, String str, int left, int right) {
		if(left == 0 && right == 0) {
			parenthesisList.add(str);
			return;
		}
		// We do not want invalid bracket combinations where right closes before left.
		if(left > right)
			return;
		
		if(left >0) {
			generateParenthesis(parenthesisList, str + "(", left-1, right);
		}
		
		if(right >0) {
			generateParenthesis(parenthesisList, str + ")", left, right-1);
		}
	}
}
