package com.kausha.algo.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/remove-k-digits/
/**
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * @author sinkar
 *
 */
public class RemoveKNumsToFormSmallestNum {

	public static void main(String[] args) {
		RemoveKNumsToFormSmallestNum rn = new RemoveKNumsToFormSmallestNum();
		
		System.out.println(rn.removeKdigits("1432219", 3)); // 1219
		System.out.println(rn.removeKdigits("234012", 3)); // 12
		System.out.println(rn.removeKdigits("10200", 1)); // 200
		System.out.println(rn.removeKdigits("10", 1)); // 0
		System.out.println(rn.removeKdigits("1234567", 3)); // 1234
		System.out.println(rn.removeKdigits("112", 1)); // 11

		System.out.println(rn.removeKdigits("134", 1)); // 11
		System.out.println(rn.removeKdigits("143", 1)); // 11
	}

	public String removeKdigits(String num, int k) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<num.length(); i++) {
			while(!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
				stack.pop();
				k--;
			}
			
			if((stack.isEmpty() && num.charAt(i) != '0') || !stack.isEmpty())
				stack.push(num.charAt(i));
		}
		
		// If we have not removed all 'k' elements, it implies that the remaining numbers 
		// in stack were all increasing. Hence we must pop those many remaining numbers.
		// Rebuild the remaining string
		while(!stack.isEmpty() && k-- > 0)
			stack.pop();
		
		String str = "";
		if(stack.isEmpty())
			str = "0";
		
		while(!stack.isEmpty())
			str = stack.pop() + str;
		
		return str;
	}
	
	// The overall idea is to:
	// Remove any peak number from right to left.
	// If we end up having '0' at the start, remove it automatically.
	public String removeKdigits2(String num, int k) {
		Stack<Integer> digits = new Stack<>();
		digits.push(num.charAt(0) - '0');
		int idx = 1;
		while(k != 0 && idx < num.length()) {
			if(digits.isEmpty() && num.charAt(idx) == '0') {
				// Do not add leading '0' to stack.
				idx++;
			} else if(digits.isEmpty() || num.charAt(idx)-'0' >= digits.peek()) {
				digits.push(num.charAt(idx) - '0');
				idx++;
			}else {
				digits.pop();
				k--;
			}
		}
		System.out.println("Idx: " + idx);
		// If we have not removed all 'k' elements, it implies that the remaining numbers in stack were all increasing.
		// Hence we must pop those many remaining numbers.
		// Rebuild the remaining string
		while(!digits.isEmpty() && k-- > 0)
			digits.pop();
		
		String str = "";
		while(!digits.isEmpty())
			str = digits.pop() + str;
		System.out.println("str:: " + str);
		if("".contentEquals(str)) {
			while(idx < num.length() && num.charAt(idx) == '0')
				idx++;
		}
		if(idx < num.length())
			str += num.substring(idx);
		if("".contentEquals(str))
			str = "0";
		// Remove any prefix '0' to the final number
		
        return str;
    }
}
