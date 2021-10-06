package com.kausha.algo.leetcode;

// https://leetcode.com/problems/valid-perfect-square/
/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.

 

Example 1:

Input: num = 16
Output: true
Example 2:

Input: num = 14
Output: false

 * @author sinkar
 *
 */

public class ValidPerfectSquare {

	public static void main(String[] args) {
		ValidPerfectSquare vps = new ValidPerfectSquare();
		
		System.out.println(vps.isPerfectSquare(16));
		System.out.println(vps.isPerfectSquare(14));
		System.out.println(vps.isPerfectSquare(1));
		System.out.println(vps.isPerfectSquare(3));
		System.out.println(vps.isPerfectSquare(808201));

		System.out.println(" ************ " + Math.sqrt(808201));
	}

	// We will use binary Search and then square the number to check perfect square.
	// Though I wrote the correct logic, the data type I earlier used for square was int which caused
	// number to go out of range of int and caused unexpected outcome for large numbers.
	// Hence used 'long' type when multiplying ints.
	public boolean isPerfectSquare(int num) {
		if(num == 1)
			return true;
		
        long start = 0;
        long end = num/2 + 1;
        
        while(start <= end) {
        	long mid = start + (end-start)/2;
        	long square = mid*mid;
        	
        	if(square == num)
        		return true;
        	else if(square < num)
        		start = mid+1;
        	else
        		end = mid-1;
        }
		
		return false;
    }
}
