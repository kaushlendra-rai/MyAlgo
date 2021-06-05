package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/print-anagrams-together/1/?company[]=Microsoft&company[]=Microsoft&page=1&query=company[]Microsoftpage1company[]Microsoft
// https://leetcode.com/problems/group-anagrams/submissions/
public class PrintAnagramsTogether {

	public static void main(String[] args) {
		//String[] strs = new String[]{"act","god","cat","dog","tac"};
		String[] strs = new String[]{};
		
		PrintAnagramsTogether pa = new PrintAnagramsTogether();
		System.out.println(pa.Anagrams(strs));
		
		System.out.println(pa.groupAnagrams(strs));
	}

	public List<List<String>> Anagrams(String[] string_list) {
        List<List<String>> anagrams = new ArrayList<>();
        if(string_list == null)
        	return anagrams;
        
        Map<String, List<String>> anagramMap = new HashMap<>();
        // The objective is to sort all words and check if a word already exists.
        for(int i=0; i < string_list.length; i++) {
        	String sorted = getSortedString(string_list[i]);
        	if(anagramMap.get(sorted) != null) {
        		anagramMap.get(sorted).add(string_list[i]);
        	}else {
        		List<String> words = new ArrayList<>();
        		words.add(string_list[i]);
        		anagramMap.put(sorted, words);
        	}
        }
        
        anagramMap.forEach((k, v) -> anagrams.add(v));
        
        return anagrams;
    }
	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> anagrams = new ArrayList<>();
	    if(strs == null)
	    	return anagrams;
	    
	    Map<String, List<String>> anagramMap = new HashMap<>();
	    // The objective is to sort all words and check if a word already exists.
	    for(int i=0; i < strs.length; i++) {
	    	String sorted = getSortedString(strs[i]);
	    	if(anagramMap.get(sorted) != null) {
	    		anagramMap.get(sorted).add(strs[i]);
	    	}else {
	    		List<String> words = new ArrayList<>();
	    		words.add(strs[i]);
	    		anagramMap.put(sorted, words);
	    	}
	    }
	    
	    anagramMap.forEach((k, v) -> anagrams.add(v));
	    
	    return anagrams;
    }
	private String getSortedString(String word) {
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}
