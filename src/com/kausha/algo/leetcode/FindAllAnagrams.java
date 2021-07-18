package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
 * @author sinkar
 *
 */
public class FindAllAnagrams {

	public static void main(String[] args) {
		FindAllAnagrams fa = new FindAllAnagrams();
		String s = "cbaebabacd";
		String p = "abc"; 
//		String s = "abab";
//		String p = "ab"; 
//		String s = "baa";
//		String p = "aa"; 
		System.out.println(fa.findAnagrams(s, p));

	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> anagramsStartIdx = new ArrayList<>();
		if(p.length() > s.length())
			return anagramsStartIdx;
     
        int[] pCharFreq = claculateCharFrequency(p);
        int[] sCharFreq = claculateCharFrequency(s.substring(0,p.length()));
        if(isArrayEqual(sCharFreq, pCharFreq))
        	anagramsStartIdx.add(0);
        
        for(int i=p.length(); i < s.length(); i++) {
        	sCharFreq[s.charAt(i - p.length()) - 'a'] -=1;
        	sCharFreq[s.charAt(i) - 'a'] +=1;
        	
        	if(isArrayEqual(sCharFreq, pCharFreq))
        		anagramsStartIdx.add(i-p.length()+1);
        }
        return anagramsStartIdx;
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
