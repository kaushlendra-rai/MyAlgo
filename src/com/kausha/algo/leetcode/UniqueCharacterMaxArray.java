package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
/**
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr 
 * which have unique characters.

Return the maximum possible length of s.
Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lower case English letters.
 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.

 * @author sinkar
 *
 */
public class UniqueCharacterMaxArray {
	public static void main(String[] args) {
		UniqueCharacterMaxArray uc = new UniqueCharacterMaxArray();
		List<String> arr = new ArrayList<>();
		arr.add("ccjhk");
		arr.add("aasd");
		
//		arr.add("ab");
//		arr.add("cd");
//		arr.add("ae");
		
//		arr.add("un");  // Ans : =4
//		arr.add("iq");
//		arr.add("ue");
		
//		arr.add("cha");  // Ans = 6
//		arr.add("r");
//		arr.add("act");
//		arr.add("ers");
		
		//arr.add("abcdefghijklmnopqrstuvwxyz");  // Ans: 26
		
//		arr.add("abcd");  // Ans = 8
//		arr.add("bcde");
//		arr.add("cdef");
//		arr.add("defg");
//		arr.add("efgh");
		
//		arr.add("abc");  // Ans = 6
//		arr.add("bcd");
//		arr.add("cde");
//		arr.add("def");
		
		System.out.println(uc.maxLength(arr));
	}
	
	public int maxLength(List<String> arr) {
		Map<Integer, Integer> repMap = getNumMap(arr);
		List<Integer> repList = new ArrayList<>(repMap.keySet());
		
		int[] maxLen = new int[1];
		maxLength(repMap, repList, 0, maxLen, 0, 0);
		
		return maxLen[0];
    }

	private void maxLength(Map<Integer, Integer> repMap, List<Integer> repList, int idx, int[] maxLen, int newNum, int currSize) {
		//maxLen[0] = maxLen[0] > currSize ? maxLen[0] : currSize;
		if(idx == repList.size()) {
			maxLen[0] = maxLen[0] > currSize ? maxLen[0] : currSize;
			return;
		}
		
		// Proceed only if the word at current index is not having any word in common with existing word.
		if((newNum & repList.get(idx)) == 0) {
			//System.out.println("Inside: idx= " + idx + " , newNum: " + newNum + "  , repList.get(idx)): " + repList.get(idx));
			// Now we may include this string rep or not for evaluating the largest number.
			maxLength(repMap, repList, idx+1, maxLen, newNum, currSize);
			maxLength(repMap, repList, idx+1, maxLen, (newNum | repList.get(idx)), currSize + repMap.get(repList.get(idx)));
		}else
			maxLength(repMap, repList, idx+1, maxLen, newNum, currSize);
	}
	
	// To reduce the number of comparisons, we represent the strings as number by setting the byte to '1'
	// at index char-'a'. The boolean & of the number if zero indicates that there is no common character.
	// If a character is duplicated in the string, do not add it to the Map.
	private Map<Integer, Integer> getNumMap(List<String> arr){
		Map<Integer, Integer> repMap = new HashMap<>();
		
		for(String str : arr) {
			int num = 0;
			boolean addToMap = true;
			for(char c : str.toCharArray()) {
				int newNum = num | 1 << (c - 'a');
				// Check if processing a character does not change the number value. It is possible only if 
				// a character is duplicate.
				if(newNum == num) {
					addToMap = false;
					break;
				}
				num = newNum;
			}
			if(addToMap)
				repMap.put(num, str.length());
		}
		
		return repMap;
	}
}
