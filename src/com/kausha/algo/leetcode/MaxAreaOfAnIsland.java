package com.kausha.algo.leetcode;

public class MaxAreaOfAnIsland {

	public static void main(String[] args) {
		MaxAreaOfAnIsland ma = new MaxAreaOfAnIsland();
//		int[][] grid = new int[][] { // Ans 4
//			{1,1,0,0,0},
//			{1,1,0,0,0},
//			{0,0,1,0,0},
//			{0,0,0,1,1}
//		};
		
//		int[][] grid = new int[][] { // Ans 6
//			{0,0,1,0,0,0,0,1,0,0,0,0,0},
//			 {0,0,0,0,0,0,0,1,1,1,0,0,0},
//			 {0,1,1,0,1,0,0,0,0,0,0,0,0},
//			 {0,1,0,0,1,1,0,0,1,0,1,0,0},
//			 {0,1,0,0,1,1,0,0,1,1,1,0,0},
//			 {0,0,0,0,0,0,0,0,0,0,1,0,0},
//			 {0,0,0,0,0,0,0,1,1,1,0,0,0},
//			 {0,0,0,0,0,0,0,1,1,0,0,0,0}
//		};
		
		int[][] grid = new int[][] {{1, 0},
			{1, 1}};
		System.out.println(ma.maxAreaOfIsland(grid));
	}

	public int maxAreaOfIsland(int[][] grid) {
		int[][] island = new int[grid.length][grid[0].length];
		int counter = 0;
		// Visit grid and isolate islands with counter numbers.
		int maxSizeCount = 0;
		int[] maxSize = new int[1];
		for(int i=0; i< grid.length; i++)
			for(int j=0; j < grid[0].length; j++)
				if(grid[i][j] == 1 && island[i][j] == 0) {
					counter++;
					visitGrid(grid, island, i, j, counter, maxSize);
					if(maxSizeCount < maxSize[0])
						maxSizeCount = maxSize[0];
					maxSize[0] = 0;
				}

        return maxSizeCount;
    }

	private void visitGrid(int[][] grid, int[][] island, int i, int j, int counter, int[] maxSize) {
		if(i<0 || i >= grid.length || j<0 || j>= grid[0].length || island[i][j] > 0 || grid[i][j] == 0)
			return;
		island[i][j] = counter;
		maxSize[0] = maxSize[0] + 1;
		visitGrid(grid, island, i+1, j, counter, maxSize);
		visitGrid(grid, island, i-1, j, counter, maxSize);
		visitGrid(grid, island, i, j+1, counter, maxSize);
		visitGrid(grid, island, i, j-1, counter, maxSize);
	}
}
