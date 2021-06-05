package com.kausha.algo.leetcode;

// https://leetcode.com/problems/valid-palindrome/
/**
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
 * @author sinkar
 *
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama")); // true
		//System.out.println(vp.isPalindrome("race a car")); // false
		//System.out.println(vp.isPalindrome(" ")); // true
		//System.out.println(vp.isPalindrome(" Aaa,")); // true
		// System.out.println(vp.isPalindrome("0P")); // true
	}

	public boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length()-1;
		boolean isPalindrome = true;
		
		while(start<end) {
			char startC = s.charAt(start);
			if(startC >= 'A' && startC <= 'Z')
				startC += 32;
			char endC = s.charAt(end);
			if(endC >= 'A' && endC <= 'Z')
				endC += 32;

			if(!((startC >= 'a' && startC <= 'z') || (startC >= '0' && startC <= '9'))) {
				start++;
			}else if(!((endC >= 'a' && endC <= 'z') || (endC >= '0' && endC <= '9'))) {
				end--;
			}else if(startC == endC){
				start++;
				end--;
			}else {
				isPalindrome = false;
				break;
			}
		}
		
        return isPalindrome;
    }
}
