package com.kausha.algo.gfg.microsoft;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/gray-code/
// https://practice.geeksforgeeks.org/problems/gray-code-1611215248/1/
// https://www.youtube.com/watch?v=KOD2BFauQbA
/**
 Given a number N, generate bit patterns from 0 to 2^N-1 such that successive patterns differ by one bit. 
A Gray code sequence must begin with 0.
 
Example 1:
Input:
N = 2
Output: 
00 01 11 10
Explanation: 
00 and 01 differ by one bit.
01 and 11 differ by one bit.
11 and 10 also differ by one bit.
 * @author sinkar
 *
 */
public class GreyCode {

	public static void main(String[] args) {
		GreyCode gc = new GreyCode();

		System.out.println(gc.graycode(2));
		System.out.println(gc.grayCode(3));
	}

	// https://leetcode.com/problems/gray-code/
	public List<Integer> grayCode(int n) {
		// Terminal condition for recursion.
		if(n == 1) {
			List<Integer> grayCode = new ArrayList<>();
			grayCode.add(0);
			grayCode.add(1);
			return grayCode;
		}
		
		List<Integer> prevGrayCode = grayCode(n-1);
		List<Integer> grayCode = new ArrayList<>();
		grayCode.addAll(prevGrayCode);
		
		int factor = 1 << n-1;
		
		for(int i=prevGrayCode.size()-1; i >= 0; i--)
			grayCode.add(prevGrayCode.get(i) | factor);
		
		return grayCode;
    }
	
	// Geeks for geeks
	public ArrayList<String> graycode(int n)
    {
		// Terminal condition for recursion.
		if(n == 1) {
			ArrayList<String> grayCode = new ArrayList<>();
			grayCode.add("0");
			grayCode.add("1");
			return grayCode;
		}
		
		ArrayList<String> prevGrayCode = graycode(n-1);
		
		ArrayList<String> grayCode = new ArrayList<>();
		for(String str : prevGrayCode)
			grayCode.add("0" + str);
		for(int i=prevGrayCode.size()-1; i >= 0; i--)
			grayCode.add("1" + prevGrayCode.get(i));
		
		return grayCode;
    }
}
