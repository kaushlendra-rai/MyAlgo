package com.kausha.algo.gfg.microsoft;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/match-specific-pattern/1/?company[]=Microsoft&company[]=Microsoft&page=1&query=company[]Microsoftpage1company[]Microsoft
/**
 * Given a dictionary of words and a pattern. Every character in the pattern is uniquely mapped to a character in the dictionary. Find all such words in the dictionary that match the given pattern. 

Example 1:

Input:
N = 4
dict[] = {abb,abc,xyz,xyy}
pattern  = foo
Output: abb xyy
Explanation: xyy and abb have the same
character at index 1 and 2 like the
pattern.

 * @author sinkar
 *
 */
public class MatchSpecificPattern {

	public static void main(String[] args) {
		
	}

	public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern)
	{
		// Here we need to compare the frequencies of consecutive words rather than the actual characters
	    return null;
	}
	
	private int[] getCharFrequency(String str) {
		
	}
}
