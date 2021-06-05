package com.kausha.algo.gfg.microsoft;

// https://practice.geeksforgeeks.org/problems/square-root/1/?company[]=Microsoft&company[]=Microsoft&page=1&query=company[]Microsoftpage1company[]Microsoft
/**
 * Given an integer x, find the square root of x. If x is not a perfect square, then return floor(√x).

 

Example 1:

Input:
x = 5
Output: 2
Explanation: Since, 5 is not a perfect 
square, floor of square_root of 5 is 2.

 * @author sinkar
 *
 */
public class SquareRootOfANumber {

	public static void main(String[] args) {
		SquareRootOfANumber sr = new SquareRootOfANumber();

		System.out.println(sr.floorSqrt(1));
		System.out.println(sr.floorSqrt(2));
		System.out.println(sr.floorSqrt(5));
		System.out.println(sr.floorSqrt(9));
		System.out.println(sr.floorSqrt(101));
	}
	
	long floorSqrt(long x)
	 {
		if(x == 1)
			return 1;
		// We kind of do a binary search to find the square root of the number.
		long sqrt = 0;
		long low = 0;
		long high = x;
		
		while(high > low) {
			double mid = low + (high-low)/2;
			if((mid * mid <= x) && ((mid+1) * (mid+1) > x )) {
				sqrt = (long)mid;
				break;
			}else if ((mid * mid > x)){
				high = (long)mid;
			}else {
				low = (long)mid;
			}
		}
		
		return sqrt;
	 }

}
