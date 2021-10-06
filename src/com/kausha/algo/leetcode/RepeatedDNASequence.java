package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/repeated-dna-sequences/
/**
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur
 more than once in a DNA molecule. You may return the answer in any order.

 

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * @author sinkar
 *
 */
public class RepeatedDNASequence {

	public static void main(String[] args) {
		RepeatedDNASequence rd = new RepeatedDNASequence();
		//System.out.println(rd.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(rd.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
	}

	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> sequence = new HashSet<>();
		Set<String> result = new HashSet<>();
		
		for(int i=0; i < s.length()-9; i++) {
			if(sequence.contains(s.substring(i, i+10))) {
				result.add(s.substring(i, i+10));
			}else
				sequence.add(s.substring(i, i+10));
		}
		return new ArrayList<String>(result);
    }
}
