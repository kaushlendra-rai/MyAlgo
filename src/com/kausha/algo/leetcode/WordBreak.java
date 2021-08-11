package com.kausha.algo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/word-break/
public class WordBreak {

	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		
//		List<String> dictionary = new LinkedList<>();
//		dictionary.add("Kaushal");
//		dictionary.add("is");
//		dictionary.add("a");
//		dictionary.add("rock");
//		dictionary.add("star");
//		dictionary.add("hero");
//		dictionary.add("champ");
//
//		
//		System.out.println(wb.wordBreak("Kaushalisarockstar", dictionary)); // Kaushal is a rock star
//		System.out.println(wb.wordBreak("Kaushal123", dictionary)); // null

		List<String> dictionary = new LinkedList<>();
		dictionary.add("cats");
		dictionary.add("dog");
		dictionary.add("sand");
		dictionary.add("and");
		dictionary.add("cat");
				
		System.out.println(wb.wordBreak("catsandog", dictionary)); // Kaushal is a rock star
		System.out.println(wb.wordBreak("catsanddog", dictionary)); // Kaushal is a rock star
				
	}
	
	private Map<String, Boolean> mem = new HashMap<>();
	
	// We use memoization here to improve time complexity.
	// It must be noted however that there is a GRID based solution(DP) which with some extra space
	// providers better time complexity. However, so far I have not done that.
	public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s))
        	return true;
        
        if(mem.get(s) != null && mem.get(s))
        	return true;
        
        for(int i=1; i<s.length(); i++) {
        	String str = s.substring(0, i);
        	
        	if(wordDict.contains(str)) {
        		String leftWord = s.substring(i);

        		if(wordBreak(leftWord, wordDict)) {
        			mem.put(s, true);
        			mem.put(leftWord, true);
        			return true;
        		}
        	}
        }
        
        mem.put(s, false);
		return false;
    }
}
