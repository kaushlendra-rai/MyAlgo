package com.kausha.algo.leetcode;

// https://leetcode.com/problems/unique-paths-ii/
/**
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

 * @author sinkar
 *
 */
public class UniquePathsOnGridWithRestrictions {

	public static void main(String[] args) {
		UniquePathsOnGridWithRestrictions up = new UniquePathsOnGridWithRestrictions();

		//int[][] obstacleGrid = new int[][] {{0,0,0}, {0,1,0}, {0,0,0}}; // 2
		//int[][] obstacleGrid = new int[][] {{0,1}, {0,0}}; // 1
		//int[][] obstacleGrid = new int[][] {{0,0}}; // 1
		//int[][] obstacleGrid = new int[][] {{0,1}}; // 0
		int[][] obstacleGrid = new int[][] {{1,0}}; // 0
		System.out.println(up.uniquePathsWithObstacles(obstacleGrid));
		
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// We can reach a node only from left & top. So, we need a recursive function to check the number\
		// of ways those left & above nodes can be reached.  So we need to sum those two to get the current
		// node's value.
	    int[][] grid = new int[obstacleGrid.length+1][obstacleGrid[0].length +1];
	    
	    for(int i=1; i <=obstacleGrid.length; i++) {
	    	for(int j=1; j<= obstacleGrid[0].length; j++) {
	    		if(obstacleGrid[i-1][j-1] == 1)
	    			grid[i][j] = 0;
	    		else if(i==1 && j ==1)
	    			grid[i][j] = 1;
	    		else
	    			grid[i][j] = grid[i][j-1] + grid[i-1][j];
	    	}
	    }
    
    	return grid[obstacleGrid.length][obstacleGrid[0].length];
    }
}
