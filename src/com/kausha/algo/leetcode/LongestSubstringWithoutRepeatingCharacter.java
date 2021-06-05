package com.kausha.algo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {

	public static void main(String[] args) {
		 String str = "abcabcbb";
		//String str = "";
		//String str = "bbbbb";
		//String str = "pwwkew";
		//String str = "b";
		//String str = "abc";
		//String str = "ohomm";
		LongestSubstringWithoutRepeatingCharacter ls = new LongestSubstringWithoutRepeatingCharacter();
		System.out.println(str);
		System.out.println("Length: " + ls.lengthOfLongestSubstring(str));
	}

	public int lengthOfLongestSubstring(String s) {
		int start = 0;
		int end = 0;
		int tempStart = 0;
		Map<String, Integer> charMap = new HashMap<>();
		
		for(int i=0; i< s.length();i++) {
			String character = s.substring(i, i+1);
			Integer charIndex = charMap.get(character);

			if(charIndex != null) {
				if (charIndex >= tempStart) {
					if(end-start < i-tempStart) {
						start = tempStart;
						end = i;
					}
					tempStart = charIndex +1;
				}
			}
			
			charMap.put(character, i);
		}
		
		if(end-start < s.length() - tempStart) {
			start = tempStart;
			end = s.length();
		}
		
		return end-start;
    }
}
