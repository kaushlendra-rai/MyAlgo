package com.kausha.algo.leetcode;

// https://leetcode.com/problems/set-matrix-zeroes/

/**
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * @author sinkar
 *
 */
public class SetMatrixZeroes {
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{0,1,2,0},{3,4,5,2}, {1,3,1,5}};
		System.out.println("Input:");
		printMatrix(matrix);
		setZeroes(matrix);
		System.out.println("Output:");
		printMatrix(matrix);
	}
	
	private static void printMatrix(int[][] matrix) {
		for(int i=0; i< matrix.length; i++) {
			for(int j=0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void setZeroes(int[][] matrix) {
	    if(matrix == null)
	        return;
	    
	    // Maintain the first row and column '0' state in seperate array of size n & m
	    // Then we parse the rows and columns to see if a given row/column is to be '0'
	    // based on num[i][j] being '0' in row/column '0'/'0'.
	    
	    boolean zeroExistInZeroRow = false;
	    int[] zeroRow = new int[matrix.length];
	    for(int i=0; i< matrix.length; i++){
	        zeroRow[i] = matrix[i][0];
	        if(matrix[i][0] == 0)
	            zeroExistInZeroRow = true;
	    }
	    
	    boolean zeroExistInZeroCol = false;
	    int[] zeroCol = new int[matrix[0].length];
	    for(int i=0; i< matrix[0].length; i++){
	        zeroCol[i] = matrix[0][i];
	        if(matrix[0][i] == 0)
	            zeroExistInZeroCol = true;
	    }
	    
	    // Traverse the Matrix
	    for(int i=1; i< matrix.length; i++){
	        for(int j=1; j< matrix[0].length; j++){
	            if(matrix[i][j] == 0){
	                matrix[i][0] = 0;
	                matrix[0][j] = 0;
	            }
	        }
	    }
	    
	    // Set zeros in matrix
	    for(int i=1; i< matrix.length; i++){
	        for(int j=1; j< matrix[0].length; j++){
	            if(matrix[i][0] == 0 || matrix[0][j] == 0){
	                matrix[i][j] =0;
	            }
	        }
	    }
	    
	    // Set zeros based on zero row & col.
	    for(int i=0; i< zeroRow.length; i++){
	        if(zeroRow[i] == 0){
	            for(int j=0; j< matrix[i].length; j++){
	                    matrix[i][j] =0;
	            }
	        }
	        if(zeroExistInZeroRow)
	            matrix[i][0] =0;
	    }
	    for(int i=0; i< zeroCol.length; i++){
	        if(zeroCol[i] == 0){
	            for(int j=0; j< matrix.length; j++){
	                matrix[j][i] =0;
	            }
	        }
	        if(zeroExistInZeroCol)
	            matrix[0][i] =0;
	    }
	}
}
