package com.kausha.algo.leetcode;

// https://leetcode.com/problems/shortest-distance-to-a-character/
/**
 * Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length
 *  and answer[i] is the distance from index i to the closest occurrence of character c in s.

The distance between two indices i and j is abs(i - j), where abs is the absolute value function.

 

Example 1:

Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
Example 2:

Input: s = "aaab", c = "b"
Output: [3,2,1,0]
 * @author sinkar
 *
 */
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
