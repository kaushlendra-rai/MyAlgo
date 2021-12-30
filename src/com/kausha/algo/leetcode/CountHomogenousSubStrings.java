package com.kausha.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// https://leetcode.com/problems/count-number-of-homogenous-substrings/
/**
 * Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.

A string is homogenous if all the characters of the string are the same.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: s = "abbcccaa"
Output: 13
Explanation: The homogenous substrings are listed as below:
"a"   appears 3 times.
"aa"  appears 1 time.
"b"   appears 2 times.
"bb"  appears 1 time.
"c"   appears 3 times.
"cc"  appears 2 times.
"ccc" appears 1 time.
3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
Example 2:

Input: s = "xy"
Output: 2
Explanation: The homogenous substrings are "x" and "y".
Example 3:

Input: s = "zzzzz"
Output: 15
 

Constraints:

1 <= s.length <= 105
s consists of lowercase letters.
 * @author sinkar
 *
 */
public class CountHomogenousSubStrings {

	public static void main(String[] args) {
		CountHomogenousSubStrings ch  = new CountHomogenousSubStrings();
		System.out.println(ch.countHomogenous("abbcccaa"));
		System.out.println(ch.countHomogenous("xy"));
		System.out.println(ch.countHomogenous("zzzzz"));
		//System.out.println(ch.countHomogenous("x"));
	}
	
	public int countHomogenous(String s) {
		if(s.length() == 1)
			return 1;
		long mod = 1000000007;
        long count = 0;
        // We first get continous same character string and their frequency in the overall string.
        
        long counter = 1;
        for(int i=1; i < s.length(); i++) {
        	if(s.charAt(i) == s.charAt(i-1)) {
        		counter++;
        	}else {
        		long temp = (counter * (counter+1)/2)%mod;
        		count = (count + temp)%mod;
        		counter = 1;
        	}
        }
        long temp = (counter * (counter+1)/2)%mod;
		count = (count + temp)%mod;

        return (int)count;
    }
}
