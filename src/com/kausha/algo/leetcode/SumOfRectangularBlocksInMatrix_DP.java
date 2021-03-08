package com.kausha.algo.leetcode;

// https://www.youtube.com/watch?v=PwDqpOMwg6U&list=PLrmLmBdmIlpuE5GEMDXWf0PWbBD9Ga1lO&index=10
// leetcode problem.

// It MUST be noted that given the basic constraints, we must explicitly calculate the sum of the block.
// The below solution is helpful if we are to serve multiple requests of sum In that case we can cache the below Sum Matrix
// and return the answers from in in O(1) time.
// It would mostly be used when a list of rectangle pairs are given for which we are to return the corresponding list of area.
// Only in such case would teh below approach be helpful.
public class SumOfRectangularBlocksInMatrix_DP {

	public static void main(String[] args) {
		int[][] data = new int[][]{
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
			};

		int startX = 1;
		int startY = 1;
		int endX = 2;
		int endY = 2;
		
		int sum = findRectangleSum(data, startX, startY, endX, endY);
		System.out.println("\nSum of Grid nodes: " + sum);
	}

	// Here I assume that the points given are from within the matrix range, If not validate them being within matrix size.
	private static int findRectangleSum(int[][] data, int startX, int startY, int endX, int endY) {
		if (data == null)
			return -1;
		
		int[][] sum = new int[data.length + 1][data[0].length + 1];
		// pre-compute sum grid
		for(int i=1; i <= data.length; i++) {
			for(int j=1; j <= data[0].length; j++) {
				sum[i][j] = sum[i-1][j] + sum[i][j-1] + data[i-1][j-1] - sum[i-1][j-1];
			}
		}
		
		for(int i=1; i <= data.length; i++) {
			for(int j=1; j <= data[0].length; j++) {
				System.out.print(sum[i][j] + " ");
			}
			System.out.println("");
		}
		
		int gridSum = sum[endY+1][endX+1] + sum[startY][startX] - sum[endY+1][startX] - sum[startY][endX+1]; 
		return gridSum;
	}
}
