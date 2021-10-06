package com.kausha.algo.leetcode;

// https://leetcode.com/problems/number-of-islands/
/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
 * @author sinkar
 *
 */
public class NumberOfIsland {

	public static void main(String[] args) {
		NumberOfIsland noi = new NumberOfIsland();
//		char[][] grid = new char[][] { // Ans 1
//			{'1','1','1','1','0'},
//			{'1','1','0','1','0'},
//			{'1','1','0','0','0'},
//			{'0','0','0','0','0'}
//		};
		
//		char[][] grid = new char[][] { // Ans 3
//			{'1','1','0','0','0'},
//			{'1','1','0','0','0'},
//			{'0','0','1','0','0'},
//			{'0','0','0','1','1'}
//		};
		char[][] grid = new char[][] { // Ans 0
			{'0'}
		};
		System.out.println(noi.numIslands(grid));
	}

	public int numIslands(char[][] grid) {
		int[][] island = new int[grid.length][grid[0].length];
		int counter = 0;
		// Visit grid and isolate islands with counter numbers.
		for(int i=0; i< grid.length; i++)
			for(int j=0; j < grid[0].length; j++)
				if(grid[i][j] == '1' && island[i][j] == 0) {
					counter++;
					visitGrid(grid, island, i, j, counter);
				}

		int maxIslandCount = 0;
		for(int i=0; i< grid.length; i++)
			for(int j=0; j < grid[0].length; j++)
				if(island[i][j]> maxIslandCount)
					maxIslandCount = island[i][j];

        return maxIslandCount;
    }

	private void visitGrid(char[][] grid, int[][] island, int i, int j, int counter) {
		if(i<0 || i >= grid.length || j<0 || j>= grid[0].length || island[i][j] > 0 || grid[i][j] == '0')
			return;
		island[i][j] = counter;
		
		visitGrid(grid, island, i+1, j, counter);
		visitGrid(grid, island, i-1, j, counter);
		visitGrid(grid, island, i, j+1, counter);
		visitGrid(grid, island, i, j-1, counter);
	}
}
