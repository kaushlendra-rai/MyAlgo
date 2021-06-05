package com.kausha.algo.gfg.microsoft;

import java.util.HashSet;
import java.util.Set;

// https://practice.geeksforgeeks.org/problems/remove-duplicates3034/1/?company[]=Microsoft&company[]=Microsoft&page=1&query=company[]Microsoftpage1company[]Microsoft
/**
 * Given a string without spaces, the task is to remove duplicates from it.

Note: The original order of characters must be kept the same. 

Example 1:

Input: S = "zvvo"
Output: "zvo"
Explanation: Only keep the first
occurrence
 * @author sinkar
 *
 */
public class RemoveDuplicateCharactersFromString {

	public static void main(String[] args) {
		RemoveDuplicateCharactersFromString rc = new RemoveDuplicateCharactersFromString();

		System.out.println(rc.removeDups("zvvo"));
		System.out.println(rc.removeDups("zvzo"));
		System.out.println(rc.removeDups(""));
	}

	String removeDups(String S) {
        StringBuilder sb = new StringBuilder();
        Set<Character> unique = new HashSet<>();
        
        for(int i=0; i<S.length(); i++)
        	if(!unique.contains(S.charAt(i))) {
        		unique.add((S.charAt(i)));
        		sb.append(S.charAt(i));
        	}
        return sb.toString();
    }
}
