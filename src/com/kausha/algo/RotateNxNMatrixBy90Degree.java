package com.kausha.algo;

// https://www.youtube.com/watch?v=aClxtDcdpsQ
public class RotateNxNMatrixBy90Degree {
	public static void main(String[] args) {
		int[][] matrix = getInitializedMatrix();
		rotateMatrix(matrix);
		printMatrix(matrix);
	}
	
	/**
	 * Rotation is possible only in a Square Matrix of N*N
	 * If rows != columns, throw Exception
	 * @param arr
	 */
	private static void rotateMatrix(int[][] arr){
		for(int outer=0; outer<=arr.length/2; outer++){
			int first = outer;
			int last = arr.length-1 - outer;
			
			for(int i=first; i<last; i++){
				int offset = i-first;
				
				// Save top element
				int top = arr[first][i];
				// Set Left-Top
				arr[first][i] = arr[last-offset][first];
				// Set Left-Bottom value
				arr[last-offset][first] = arr[last][last-offset];
				// Set Right-bottom
				arr[last][last-offset] = arr[i][last];
				//Set Right-top
				arr[i][last] = top;
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
		
		int[][] matrix = {
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
		};
		
		return matrix;
	}
}