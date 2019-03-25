package com.kausha.algo;

public class SpiralMatrixPrinting {

	public static void main(String[] args) {
		int[][] arr = {
					{1, 1, 1, 1},
					{2, 2, 2, 2},
					{3, 3, 3, 3},
					{4, 4, 4, 4},
					{5, 5, 5, 5}};
		
		spiralPrintingOfMatrix(arr);
	}
	
	private static void spiralPrintingOfMatrix(int[][] arr){
		int left = 0;
		int top = 0;
		int bottom = arr.length-1;
		int right = arr[0].length-1;
		
		for(int i = 0; i <= arr.length/2; i++){
			
			for(int j=left; j < right; j++)
				System.out.println(arr[top][j]);
			
			for(int j=top; j < bottom; j++)
				System.out.println(arr[j][right]);
			
			for(int j=right; j > left; j--)
				System.out.println(arr[bottom][j]);
			
			for(int j=bottom; j > top; j--)
				System.out.println(arr[j][left]);
			
			left++;
			top++;
			bottom--;
			right--;
			
		}
	}

}
