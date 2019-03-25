package com.kausha.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class GroupAnagramsInString {
	public static void main(String[] args) {
		String input = "abcd asw dcab gkjhk kjhkjh was saw";
		Map<String, Set<String>> result = groupAnagrams(input);
		
		Iterator<Entry<String, Set<String>>> iterator = result.entrySet().iterator();
		
		while(iterator.hasNext()){
			Entry<String, Set<String>> entry = iterator.next();
			System.out.println("Key = " + entry.getKey());
			System.out.println("Value = " + entry.getValue());
		}
	}
	
	private static Map<String, Set<String>> groupAnagrams(String input){
		Scanner scanner = new Scanner(input);
		Map<String, Set<String>> result = new HashMap<String, Set<String>>();
		
		while(scanner.hasNext()){
			String word = scanner.next();
			String sortedWord = sortString(word);
			
			if(result.get(sortedWord) == null){
				Set<String> newEntry = new HashSet<String>();
				newEntry.add(word);
				result.put(sortedWord, newEntry);
			}else{
				result.get(sortedWord).add(word);
			}
		}
		
		return result;
	}

	private static String sortString(String word) {
		char[] charArray = word.toCharArray();
		
		Arrays.sort(charArray);
		
		return new String(charArray);
	}
}