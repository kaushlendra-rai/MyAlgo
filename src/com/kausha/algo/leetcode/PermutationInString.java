package com.kausha.algo.leetcode;

// https://leetcode.com/problems/permutation-in-string/
/**
 * Given two strings s1 and s2, return true if s2 contains the permutation of s1.

In other words, one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false

 * @author sinkar
 *
 */
public class PermutationInString {

	public static void main(String[] args) {
		String s1 = "ab";
		//String s2 = "eidbaooo";
		String s2 = "eidboaoo";
		PermutationInString ps = new PermutationInString();
		System.out.println(ps.checkInclusion(s1, s2));
	}

	/**
	 * We will use the anagram with sliding window approach to solve this problem.
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean checkInclusion(String s1, String s2) {
		if(s1.length() > s2.length())
			return false;
     
        int[] s1CharFreq = claculateCharFrequency(s1);
        int[] s2CharFreq = claculateCharFrequency(s2.substring(0,s1.length()));
        if(isArrayEqual(s1CharFreq, s2CharFreq))
        	return true;
        
        for(int i=s1.length(); i < s2.length(); i++) {
        	s2CharFreq[s2.charAt(i - s1.length()) - 'a'] -=1;
        	s2CharFreq[s2.charAt(i) - 'a'] +=1;
        	
        	if(isArrayEqual(s1CharFreq, s2CharFreq))
            	return true;	
        }
        
		return false;
    }
	
	private int[] claculateCharFrequency(String str) {
		int[] charFreq = new int[26];
		for(int i=0; i< str.length(); i++) {
			charFreq[str.charAt(i) - 'a'] += 1; 
		}
		return charFreq;
	}
	
	private boolean isArrayEqual(int[] arr1, int[] arr2) {
		for(int i=0; i< arr1.length; i++) {
			if(arr1[i] != arr2[i])
				return false;
		}
		return true;
	}
}
