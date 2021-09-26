package com.kausha.algo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
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
		System.out.println("Length: " + ls.lengthOfLongestSubstring_HashMap(str));
	}

	public int lengthOfLongestSubstring(String s) {
		boolean[] visited = new boolean[26];
		int maxLen = 0;
		
		int len = 0;
		int idx = 0;
		int start = 0;

		while(idx < s.length() && start <= idx) {
			if(!visited[s.charAt(idx) - 'a']) {
				visited[s.charAt(idx) - 'a'] = true;
				len++;
				idx++;

				if(len  > maxLen)
					maxLen = len;
			}else {
				visited[start++] = false;
				len--;
			}
		}
		
		return maxLen;
	}
	
	public int lengthOfLongestSubstring_HashMap(String s) {
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
