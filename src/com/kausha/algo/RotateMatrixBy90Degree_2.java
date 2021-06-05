package com.kausha.algo;

public class RotateMatrixBy90Degree_2 {
	public static void main(String[] args) {
		int[][] matrix = getInitializedMatrix();
		rotateMatrix(matrix);
		printMatrix(matrix);
	}
	
	private static void rotateMatrix(int[][] matrix) {
		for(int i=0; i < matrix.length/2; i++){
			int start = i;
			int end = matrix.length - 1 - i;
			
			for(int j= start; j < end; j++){
				
				int temp = matrix[start][j];
				matrix[start][j] = matrix[end-j][start];
				matrix[end-j][start] = matrix[end][end-j];
				matrix[end][end-j] = matrix[j][end];
				matrix[j][end] = temp;
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
	
	private static int[][] getInitializedMatrix(){
		/*int[][] matrix = {{1, 2, 3, 4, 5, 6},
				{1, 2, 3, 4, 5, 6},
				{1, 2, 3, 4, 5, 6},
				{1, 2, 3, 4, 5, 6},
				{1, 2, 3, 4, 5, 6},
				{1, 2, 3, 4, 5, 6}
		};*/
		
		int[][] matrix1 = {
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
		};
		
		int[][] matrix = new int[][] {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		}; 
		
		return matrix;
	}
}