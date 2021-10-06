package com.kausha.algo.leetcode;

// https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWordsInAString {

	public static void main(String[] args) {
		ReverseWordsInAString rw = new ReverseWordsInAString();

		//System.out.println(rw.reverseWords("  I am     Sonu Rai "));
		//System.out.println(rw.reverseWords("the sky is blue"));
		// System.out.println(rw.reverseWords("  hello world  "));
		System.out.println(rw.reverseWords("  Bob    Loves  Alice   "));
	}

	public String reverseWords(String s) {
		// First remove any unwanted space from the original string.
		// Then we reverse all the characters of the string.
		StringBuilder sb = new StringBuilder();
		int leadingSpaceCounter=0;
		for(int i=0; i < s.length();i++)
			if(s.charAt(i) == ' ')
				leadingSpaceCounter++;
			else
				break;
		
		// reverse the string and exclude any extra space.
		for(int i=s.length()-1; i >=leadingSpaceCounter ; i--) {
			if(!((i == s.length()-1 && s.charAt(i) == ' ') || (s.charAt(i) == ' ' && s.charAt(i+1) == ' '))) {
				sb.append(s.charAt(i));
			}
		}
		
		//We reverse the individual words.
		int start=0;
		int end = 0;
		
		while(end <sb.length()) {
			if(sb.charAt(end) == ' ') {
				int temp = end-1;
				while(start <= temp) {
					char tempChar = sb.charAt(start);
					sb.setCharAt(start++, sb.charAt(temp));
					sb.setCharAt(temp--, tempChar);
				}

				start = end+1;
			}
			end++;
		}		
		
		// We need to reverse the last word which would get left out in above loop.
		end--;
		while(start <= end) {
			char tempChar = sb.charAt(start);
			sb.setCharAt(start++, sb.charAt(end));
			sb.setCharAt(end--, tempChar);
		}
		
        return sb.toString();
    }
}
