package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/perfect-squares/
/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer 
with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 * @author sinkar
 *
 */
public class PerfectSquare {

	public static void main(String[] args) {
		PerfectSquare ps = new PerfectSquare();
		
		//System.out.println(ps.numSquares(12)); // 3
		// System.out.println(ps.numSquares(13)); // 2
		//System.out.println(ps.numSquares(1)); // 1
		System.out.println(ps.numSquares(4)); // 1
		System.out.println(ps.numSquares_itrMemo(4)); // 1
	}

	// Iterative bottom-up memoization with O(n) time & O(n) extra space.
	// This one seems better than the 2D matrix solution.
	public int numSquares_itrMemo(int n) {
		if(n <= 3)
			return n;
		// We know that below are base cases and minimal in counts.
		int[] mem = new int[n+1];
		mem[0] = 0;
		mem[1] = 1;
		mem[2] = 2;
		mem[3] = 3;
		
		for(int i=4; i <= n; i++) {
			int sqrtNum = (int)Math.sqrt(i);
			mem[i] = 1 + mem[i - sqrtNum * sqrtNum];
		}
		
		return mem[n];
	}
	
	public int numSquares_recurMemo(int n) {
		if(n <= 3)
			return n;
		int numSquares = 0;
		
		for(int i=1; i*i <=n; i++) {
			numSquares = Math.min(numSquares, 1 + numSquares_recurMemo(n-(i*i)));
		}
		
		return numSquares;
	}
	
	public int numSquares(int n) {
		if(n == 1)
			return 1;
		
		List<Integer> ps = new ArrayList<>();
		// We try to find the maximum number whose square could be used to make up the number 'n'.
		int num = 1;
		while(num*num <= n) {
			ps.add(num*num);
			num++;
		}
		int[][] grid = new int[ps.size() + 1][n+1];
		
		for(int j=1; j < grid[0].length; j++) {
			grid[0][j] = Integer.MAX_VALUE;
		}
		
		for(int i=1; i<grid.length; i++) {
			for(int j=1; j < grid[0].length; j++) {
				int div = j/ps.get(i-1);
				int divMin = grid[i-1][j-ps.get(i-1)*div];
				grid[i][j] = Math.min(grid[i-1][j], div + divMin);
			}
		}
		
		for(int i=1; i<grid.length; i++) {
			for(int j=1; j < grid[0].length; j++) {
				System.out.print(" " + grid[i][j]);
			}
			System.out.println();
		}
        return grid[ps.size()][n];
    }
}
