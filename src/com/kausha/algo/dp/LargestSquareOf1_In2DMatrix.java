package com.kausha.algo.dp;

// https://www.youtube.com/watch?v=FO7VXDfS8Gk
public class LargestSquareOf1_In2DMatrix {
	public static void main(String[] args) {
		int[][] input = new int[][] {
			{1, 1, 0, 1, 0},
			{0, 1, 1, 1, 0},
			{1, 1, 1, 1, 0},
			{0, 1, 1, 1, 1}
		};
		
		System.out.println(getMaxSquareSizeOf1(input));
	}

	private static int getMaxSquareSizeOf1(int[][] input) {
		int maxSquareSize = 0;
		int[][] cache = new int[input.length + 1][input[0].length + 1];
		
		for(int i = 0; i < input.length; i++) {
			for(int j=0; j<input[0].length; j++) {
				int min = cache[i][j] > cache[i+1][j] ? cache[i+1][j] : cache[i][j];
				min = min > cache[i][j+1] ? cache[i][j+1]: min;
				cache[i+1][j+1] = min + input[i][j];
				
				maxSquareSize = maxSquareSize < cache[i+1][j+1] ? cache[i+1][j+1] : maxSquareSize;  
			}
		}
		return maxSquareSize;
	}
}
