package com.kausha.algo.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/valid-anagram/
/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false

 * @author sinkar
 *
 */
public class ValidateAnagram {

	public static void main(String[] args) {
		ValidateAnagram va = new ValidateAnagram();
		System.out.println(va.isAnagram("anagram", "nagaram"));

	}

	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length())
			return false;
        return getSortedString(s).equals(getSortedString(t));
    }
	
	private String getSortedString(String word) {
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}
