package com.kausha.algo.leetcode;

// https://leetcode.com/problems/ugly-number/
// Given an integer n, return true if n is an ugly number.
// Ugly number is a positive number whose prime factors only include 2, 3, and/or 5.
public class UglyNumber {

	public static void main(String[] args) {
		UglyNumber un = new UglyNumber();
		System.out.println(un.isUgly(12));
		System.out.println(un.isUgly(14));
		System.out.println(un.isUgly(6));
		System.out.println(un.isUgly(8));
		System.out.println(un.isUgly(1));
		System.out.println(un.isUgly(-1000));
	}

	public boolean isUgly(int n) {
		if(n <= 0)
			return false;
		else if(n == 1)
			return true;
		
		boolean ugly = false;
		while(true) {
			if(n%2 == 0)
				n = n/2;
			else if(n%3 == 0)
				n = n/3;
			else if(n%5 == 0)
				n = n/5;
			else
				break;
			
			if(n == 1) {
				ugly = true;
				break;
			}
		}
		
        return ugly;
    }
}
