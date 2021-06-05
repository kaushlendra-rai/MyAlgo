package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters
 * @author sinkar
 *
 */
public class LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		LetterCombinationsOfPhoneNumber number = new LetterCombinationsOfPhoneNumber();
		
		//String digits = "23";
		String digits = "2";
		System.out.println(number.letterCombinations(digits));
	}

	public List<String> letterCombinations(String digits) {
		Map<String, String[]> numMap = new HashMap<>();
		numMap.put("2", new String[] {"a", "b", "c"});
		numMap.put("3", new String[] {"d", "e", "f"});
		numMap.put("4", new String[] {"g", "h", "i"});
		numMap.put("5", new String[] {"j", "k", "l"});
		numMap.put("6", new String[] {"m", "n", "o"});
		numMap.put("7", new String[] {"p", "q", "r", "s"});
		numMap.put("8", new String[] {"t", "u", "v"});
		numMap.put("9", new String[] {"w", "x", "y", "z"});
		
		List<String> combinations = new ArrayList<>();
		for(int i=0; i < digits.length(); i++) {
			List<String> temp = new ArrayList<>();
			String[] characters = numMap.get(digits.substring(i, i+1));
			if(combinations.size() == 0) {
				for(int k=0; k< characters.length; k++)
					temp.add(characters[k]);
			}else
				for(int j=0; j< combinations.size(); j++) {
					for(int k=0; k< characters.length; k++)
						temp.add(combinations.get(j) + characters[k]);
				}
			combinations = temp;
		}
		
        return combinations;
    }
}
