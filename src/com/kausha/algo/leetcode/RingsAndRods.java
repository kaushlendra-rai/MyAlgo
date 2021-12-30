package com.kausha.algo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/rings-and-rods/
/**
 * There are n rings and each ring is either red, green, or blue. The rings are distributed across
 *  ten rods labeled from 0 to 9.

You are given a string rings of length 2n that describes the n rings that are placed onto the rods.
 Every two characters in rings forms a color-position pair that is used to describe each ring where:

The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B').
The second character of the ith pair denotes the rod that the ith ring is placed on ('0' to '9').
For example, "R3G2B1" describes n == 3 rings: a red ring placed onto the rod labeled 3, a green ring 
placed onto the rod labeled 2, and a blue ring placed onto the rod labeled 1.
 * @author sinkar
 *
 */
public class RingsAndRods {

	public static void main(String[] args) {
		RingsAndRods ror = new RingsAndRods();
		System.out.println(ror.countPoints("B0B6G0R6R0R6G9"));
		
		System.out.println(ror.countPoints("B0R0G0R9R0B0G0"));
		System.out.println(ror.countPoints("G4"));
		System.out.println(ror.countPoints("R4G4B4R1G1B1"));
	}

	// The question should also be solvable by using array of size 10 with value 1 each.
	// For R, multiply by 2 if num not divisible by 2
	// For B, multiply by 3 if num not divisible by 3
	// For G, multiply by 5 if num not divisible by 5
	// The final element having value 30 has all elements.
	public int countPoints(String rings) {
        int count = 0;
        Map<Integer, Set<Character>> map = new HashMap<>();
        for(int i=0; i< rings.length(); i +=2) {
        	Character c = rings.charAt(i);
        	Integer idx = Integer.parseInt(rings.substring(i+1, i+2), 10);
        	Set<Character> data = map.get(idx);
        	if(data == null) {
        		data = new HashSet<>();
        	}
        	data.add(c);
        	map.put(idx, data);
        }
        
        for(Set<Character> values : map.values()) {
        	if(values.size() == 3)
        		count++;
        }
        
        return count;
    }
}
