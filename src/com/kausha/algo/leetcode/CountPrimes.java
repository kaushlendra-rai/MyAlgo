package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-primes/
/**
 * Given an integer n, return the number of prime numbers that are strictly less than n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 * @author sinkar
 *
 */
public class CountPrimes {

	public static void main(String[] args) {
		CountPrimes cp = new CountPrimes();
		
		System.out.println(cp.countPrimes(10)); // 4
		System.out.println(cp.countPrimes(0));
		System.out.println(cp.countPrimes(1));
		System.out.println(cp.countPrimes(2));
		System.out.println(cp.countPrimes(3));
		System.out.println("Slow: " + cp.countPrimes_slow(499979));
		
		long start = System.currentTimeMillis();	
		System.out.println("Fast: " + cp.countPrimes(499979)); // 14391 ms (with set) , 3450 with List (Still timeExceeded)
		System.out.println("Time in ms : " + (System.currentTimeMillis() - start));
		
	}

	// This is fast but take extra O(n) space
	public int countPrimes(int n) {
		if(n<2)
			return 0;
		boolean[] primes = new boolean[n];
		primes[0] = primes[1] = true;
		
		int counter = 0;
		for(int i=2; i<n; i++) {
			if(!primes[i]) {
				counter++;
				
				int idx = 1;
				while(idx*i < n) {
					primes[idx++ * i] = true;
				}
			}
		}
		
		return counter;
	}
	
	// The below approach is causing TimeExceeded in leetcode.
	// However, it MUST be noted that this does not take extra memory.
	public int countPrimes_slow(int n) {
		if(n<2)
			return 0;
		List<Integer> primes = new ArrayList<>();
		
		for(int i=2; i < n; i++) {
			if(isPrime(i, primes))
				primes.add(i);
		}
		
        return primes.size();
    }
	
	private boolean isPrime(int num, List<Integer> primes) {
		for(int prime: primes)
			if(num%prime == 0)
				return false;
		return true;
	}
}
