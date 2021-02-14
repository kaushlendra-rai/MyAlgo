package com.kausha.algo.dp;

// https://www.youtube.com/watch?v=oPrpoVdRLtg
// Given a binary grid, find the biggest square filled with digit 1.
// It must be noted that the requirement is to send the square implying the area of square.
// LeetCode
public class LargestContigousSquareOf1InMatrix {

	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{ 1, 0, 1, 0, 0 },
			{ 1, 0, 1, 1, 1 },
			{ 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 1, 0 },
		};
		System.out.println("Larget Square Area: " + getLargestSquareSumOfOne(matrix));
	}
	
	public static int getLargestSquareSumOfOne(int[][] arr) {
		if(arr == null || arr.length == 0)
			return 0;
		
		int maxSize = 0;
		// Create a matrix to hold the DP state of squares.
		int[][] size = new int[arr.length +1][arr[0].length+1];
		
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr[0].length; j++) {
				if(arr[i][j] == 1) {
					int	min = Math.min(size[i][j], size[i][j+1]);
					min = Math.min(min, size[i+1][j]);
					size[i+1][j+1] = min+1;
					
					if(maxSize < min+1)
						maxSize = min+1;
				}
			}
		}
		
		return maxSize * maxSize;
	}
}
