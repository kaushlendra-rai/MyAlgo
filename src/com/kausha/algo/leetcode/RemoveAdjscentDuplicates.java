package com.kausha.algo.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
/**
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing 
 * two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. 
It can be proven that the answer is unique.

 

Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal,
 and this is the only possible move.  The result of this move is that the string is "aaca", of which
  only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
 * @author sinkar
 *
 */
public class RemoveAdjscentDuplicates {

	public static void main(String[] args) {
		System.out.println(new RemoveAdjscentDuplicates().removeDuplicates("acaaabbbacdddd"));
		System.out.println(new RemoveAdjscentDuplicates().removeDuplicates("acaaabbbac"));
		System.out.println(new RemoveAdjscentDuplicates().removeDuplicates("aac"));
		System.out.println(new RemoveAdjscentDuplicates().removeDuplicates("kr"));
		System.out.println(new RemoveAdjscentDuplicates().removeDuplicates("kk"));
		System.out.println(new RemoveAdjscentDuplicates().removeDuplicates("k"));
		
		System.out.println(new RemoveAdjscentDuplicates().removeDuplicates("abbaca"));
		System.out.println(new RemoveAdjscentDuplicates().removeDuplicates("aaaaaaaaa"));
		System.out.println(new RemoveAdjscentDuplicates().removeDuplicates("azxxzy"));
		
	}

	public String removeDuplicates(String str) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(stack.isEmpty()) {
				stack.push(c);
			}else if(stack.peek() == c) {
				stack.pop();
			}else {
				stack.push(c);
			}
		}
		
		String rd = "";
		while(!stack.isEmpty()) {
			rd = stack.pop() + rd;
		}
		
		return rd;
	}
}
