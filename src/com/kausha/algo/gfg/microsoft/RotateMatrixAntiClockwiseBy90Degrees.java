package com.kausha.algo.gfg.microsoft;

// https://leetcode.com/problems/rotate-image/
public class RotateMatrixAntiClockwiseBy90Degrees {

	public static void main(String[] args) {
		RotateMatrixAntiClockwiseBy90Degrees rm = new RotateMatrixAntiClockwiseBy90Degrees();
		int[][] matrix1 = new int[][] {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		int[][] matrix = {
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
		};
		System.out.println("Input:");
		printMatrix(matrix);
		rm.rotate(matrix);
		System.out.println("Output:");
		printMatrix(matrix);
	}
	
	public void rotate(int[][] matrix) {
		
		for(int outer=0; outer<= matrix.length/2; outer++) {
			int first = outer;
			int last = matrix.length-1 -first;
			for(int i=first; i < last; i++) {
				// Swap the four nums on the boundaries in one loop.
				int offset = i - first;
				int top = matrix[first][i];
				
				matrix[first][i] = matrix[i][last];
				
				matrix[i][last] = matrix[last][last-offset];
				
				matrix[last][last-offset] = matrix[last-offset][first];
				
				matrix[last-offset][first] = top;
			}
		}
    }
	
	private static void printMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j=0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
