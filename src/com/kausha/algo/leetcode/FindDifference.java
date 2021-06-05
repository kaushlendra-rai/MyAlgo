package com.kausha.algo.leetcode;

// https://leetcode.com/problems/find-the-difference/
/**
 * You are given two strings s and t.

String t is generated by random shuffling string s and then add one more letter at a random position.

Return the letter that was added to t.

 

Example 1:

Input: s = "abcd", t = "abcde"
Output: "e"
Explanation: 'e' is the letter that was added.
 * @author sinkar
 *
 */
public class FindDifference {

	public static void main(String[] args) {
		FindDifference fd = new FindDifference();

		//System.out.println(fd.findTheDifference("abcd", "abecd"));
		//System.out.println(fd.findTheDifference("", "y"));
		System.out.println(fd.findTheDifference("a", "aa"));
	}

	public char findTheDifference(String s, String t) {
		int loopLen = 0;
		int diff = 0;
		if(s.length() > t.length()) {
			loopLen = t.length();
			diff = s.charAt(s.length()-1);
		}else {
			loopLen = s.length();
			diff = t.charAt(t.length()-1);
		}
		
		for(int i=0; i < loopLen; i++) {
			diff = diff ^ s.charAt(i) ^ t.charAt(i);
		}
		
        return (char)diff;
    }

}
