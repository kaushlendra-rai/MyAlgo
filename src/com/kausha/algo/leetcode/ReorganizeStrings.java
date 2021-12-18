package com.kausha.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/reorganize-string/
/**
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

 

Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""
 * @author sinkar
 *
 */
public class ReorganizeStrings {

	public static void main(String[] args) {
		ReorganizeStrings rs = new ReorganizeStrings();
		System.out.println("Output: " + rs.reorganizeString("aab"));
		System.out.println("Output: " + rs.reorganizeString("aaab"));
		System.out.println("Output: " + rs.reorganizeString("baaba"));
	}

	public String reorganizeString(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i < s.length(); i++) {
			Character c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		PriorityQueue<CharFreq> maxHeap = new PriorityQueue<>();
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			maxHeap.offer(new CharFreq(entry.getKey(), entry.getValue()));
		}
		
		StringBuilder sb = new StringBuilder();
		CharFreq tmp = null;
		while(!maxHeap.isEmpty()) {
			//System.out.println("maxHeap.size: " + maxHeap.size());
			CharFreq max = maxHeap.poll();
			
			if(tmp != null)
				maxHeap.offer(tmp);
			
			// Check if the Conversion/rotation if not possible.
			if(maxHeap.size() == 0 && max.freq > 1)
				return "";
			
			sb.append(max.getC());
			max.freq--;
			
			if(max.freq > 0)
				tmp = max;
			else
				tmp = null;
		}
		
		return sb.toString();
    }
}

class CharFreq implements Comparable<CharFreq>{
	int freq;
	Character c;
	
	public CharFreq(Character c, int freq) {
		super();
		this.freq = freq;
		this.c = c;
	}
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	public Character getC() {
		return c;
	}
	public void setC(Character c) {
		this.c = c;
	}
	@Override
	public int compareTo(CharFreq o) {
		return o.freq- freq;
	}
}