package com.kausha.algo.leetcode;

// https://leetcode.com/problems/maximal-rectangle/
public class MaximumRectangle {

	public static void main(String[] args) {
		MaximumRectangle mr = new MaximumRectangle();
		char[][] matrix = new char[][] {{1, 0}};
		System.out.println(mr.maximalRectangle(matrix));
	}
	
	public int maximalRectangle(char[][] matrix) {
		if(matrix.length == 0)
			return 0;
		
		int[][] rectCount = new int[matrix.length+1][matrix[0].length];
		
		
        return 0;
    }

}
