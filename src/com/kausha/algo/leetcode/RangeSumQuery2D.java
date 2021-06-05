package com.kausha.algo.leetcode;

public class RangeSumQuery2D {

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
		NumMatrix nm = new NumMatrix(matrix);

		System.out.println(nm.sumRegion(2, 1, 4, 3));
		System.out.println(nm.sumRegion(1, 1, 2, 2));
		System.out.println(nm.sumRegion(1, 2, 2, 4));
	}
}

class NumMatrix {
	int[][] sum;
    public NumMatrix(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length];
        
        // Pre-compute the grid sum from (0,0) - (i, j)
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return 0;
    }
}