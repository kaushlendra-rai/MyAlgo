package com.kausha.algo.leetcode;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		//String[] strs = new String[] {"flower", "flow", "flowight", ""};
		String[] strs = new String[] {};
System.out.println(longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0)
			return "";
		
		int minLength = 200;
		for(int i=0; i < strs.length; i++)
			if(strs[i].length() < minLength)
				minLength = strs[i].length();
		
		for(int i=0; i < minLength; i++) {
			for(int j=0; j < strs.length; j++) {
				if(strs[0].charAt(i) != strs[j].charAt(i))
					return strs[0].substring(0, i);
			}
		}
		return strs[0].substring(0, minLength);
    }
}
