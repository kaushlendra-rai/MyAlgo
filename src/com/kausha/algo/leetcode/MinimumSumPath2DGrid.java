package com.kausha.algo.leetcode;


// https://leetcode.com/problems/minimum-path-sum/
/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, 
 * which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 * @author sinkar
 *
 */
public class MinimumSumPath2DGrid {

	public static void main(String[] args) {
		MinimumSumPath2DGrid up = new MinimumSumPath2DGrid();

		//int[][] obstacleGrid = new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}; // 7
		int[][] obstacleGrid = new int[][] {{1, 2, 3}, {4, 5, 6}}; // 12
		System.out.println(up.minPathSum(obstacleGrid));
	}

	// An alternate approach could be is to set the '0' row & column as Integer.MAX
	// and then use only one operation:
	// sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i-1][j-1];s
	public int minPathSum(int[][] grid) {
		 int[][] sum = new int[grid.length+1][grid[0].length +1];
		    
		 for(int i=1; i <=grid.length; i++) {
			 for(int j=1; j<= grid[0].length; j++) {
				 if(i == 1)
					 sum[i][j] = sum[i][j-1] + grid[i-1][j-1];
				 else if (j == 1)
					 sum[i][j] = sum[i-1][j] + grid[i-1][j-1];
				 else
					 sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i-1][j-1];
			 }
		 }
		 
		 return sum[grid.length][grid[0].length];
    }
}
