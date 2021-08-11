package com.kausha.algo.leetcode;

public class ShortestDistanceToACharacter {

	public static void main(String[] args) {
		ShortestDistanceToACharacter sd = new ShortestDistanceToACharacter();
		
		int[] dist = sd.shortestToChar("loveleetcode", 'e');
		for(int num : dist)
			System.out.print(" " + num);
		System.out.println();
		dist = sd.shortestToChar("aaab", 'b');
		for(int num : dist)
			System.out.print(" " + num);
	}

	public int[] shortestToChar(String s, char c) {
        int[] nums = new int[s.length()];
        
        int dist = 1;
        boolean firstFound = false;
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i) == c) {
        		nums[i] = 0;
        		int counter = 1;
        		for(int j=i-1; j >= 0; j--) {
        			if(nums[j] != 0 && nums[j] > counter) {
        				nums[j] = counter++;
        			}else
        				break;
        		}
        		firstFound = true;
        		dist = 1;
        	}else {
        		if(!firstFound)
        			nums[i] = Integer.MAX_VALUE;
        		else
        			nums[i] = dist++;
        	}
        }
        
        return nums;
    }
}
