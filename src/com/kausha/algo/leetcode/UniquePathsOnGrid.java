package com.kausha.algo.leetcode;

// https://leetcode.com/problems/unique-paths/submissions/
/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

 * @author sinkar
 *
 */
public class UniquePathsOnGrid {

	public static void main(String[] args) {
		UniquePathsOnGrid up = new UniquePathsOnGrid();

		
		System.out.println(up.uniquePaths(3, 7)); // 28
		System.out.println(up.uniquePaths(3, 2)); // 3
		
		System.out.println(up.numberOfPaths(3, 7)); // 28
		System.out.println(up.numberOfPaths(3, 2)); // 3
		System.out.println(up.numberOfPaths(3, 3)); // 6
	}

	public int uniquePaths(int m, int n) {
		// We can reach a node only from left & top. So, we need a recursive function to check the number\
		// of ways those left & above nodes can be reached.  So we need to sum those two to get the current
		// node's value.
        int[][] grid = new int[m+1][n+1];
        
        for(int i=1; i <=m; i++) {
        	for(int j=1; j<= n; j++) {
        		if(i==1 && j ==1)
        			grid[i][j] = 1;
        		else
        			grid[i][j] = grid[i][j-1] + grid[i-1][j];
        	}
        }
        
        return grid[m][n];
    }
	
	long numberOfPaths(int m, int n) {
		// We can reach a node only from left & top. So, we need a recursive function to check the number\
		// of ways those left & above nodes can be reached.  So we need to sum those two to get the current
		// node's value.
		long[][] grid = new long[m+1][n+1];
		        
		for(int i=1; i <=m; i++) {
		   	for(int j=1; j<= n; j++) {
		   		if(i==1 && j ==1)
		   			grid[i][j] = 1;
		   		else
		   			grid[i][j] = grid[i][j-1] + grid[i-1][j];
		   	}
		}
		        
		return grid[m][n];
    }
}
