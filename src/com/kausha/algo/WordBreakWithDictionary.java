package com.kausha.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://www.techiedelight.com/word-break-problem/
public class WordBreakWithDictionary {

	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
//		dictionary.add("Kaushal");
//		dictionary.add("is");
//		dictionary.add("a");
//		dictionary.add("rock");
//		dictionary.add("star");
//		dictionary.add("hero");
//		dictionary.add("champ");
//
//		System.out.println(wordBreak("Kaushalisarockstar", dictionary)); // Kaushal is a rock star
//		System.out.println(wordBreak("Kaushal123", dictionary)); // null
//		
		dictionary.add("cats");
		dictionary.add("dog");
		dictionary.add("sand");
		dictionary.add("and");
		dictionary.add("cat");
		System.out.println(wordBreak("catsandog", dictionary)); // Kaushal is a rock star
	}

	private static Map<String, String> mem = new HashMap<>();
	
	// We use memoization here to improve time complexity.
	public static String wordBreak(String str, Set<String> dictionary){
		if(dictionary.contains(str))
			return str;
		
		if(mem.containsKey(str))
			return mem.get(str);
		
		for(int i=1; i< str.length(); i++) {
			String newStr = str.substring(0, i);
			if(dictionary.contains(newStr)) {
				String subStrWord = wordBreak(str.substring(i), dictionary);
				if(subStrWord != null) {
					mem.put(str, newStr + " " + subStrWord);
					return newStr + " " + subStrWord;
				}
			}
		}
		
		// If there is no word in dictionary, then save null for the word to save extra processing.
		mem.put(str, null);
		return null;
	}
	
	// This approach though is correct, however has an O(2^n) complexity which makes it a bad solution.
	public static String wordBreak_recursion(String str, Set<String> dictionary){
		if(dictionary.contains(str))
			return str;
		
		for(int i=1; i< str.length(); i++) {
			String newStr = str.substring(0, i);
			if(dictionary.contains(newStr)) {
				String subStrWord = wordBreak(str.substring(i), dictionary);
				if(subStrWord != null)
					return newStr + " " + subStrWord;
			}
		}
		
		return null;
	}
}
