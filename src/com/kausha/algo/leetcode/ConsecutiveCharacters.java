package com.kausha.algo.leetcode;

// https://leetcode.com/problems/consecutive-characters/
/**
 * The power of the string is the maximum length of a non-empty substring that contains only one 
 * unique character.

Given a string s, return the power of s.

 

Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.
 * @author sinkar
 *
 */
public class ConsecutiveCharacters {

	public static void main(String[] args) {
		ConsecutiveCharacters cc = new ConsecutiveCharacters();
		
		System.out.println(cc.maxPower("leetcode"));
		System.out.println(cc.maxPower("abbcccddddeeeeedcba"));
	}

	public int maxPower(String s) {
        int max = 0;
        
        int counter = 1;
        for(int i=1; i < s.length(); i++) {
        	if(s.charAt(i) == s.charAt(i-1)) {
        		counter++;
        	}else {
        		if(counter > max)
        			max = counter;
        		counter = 1;
        	}
        }
        
        if(counter > max)
			max = counter;
        
        return max;
    }
}
