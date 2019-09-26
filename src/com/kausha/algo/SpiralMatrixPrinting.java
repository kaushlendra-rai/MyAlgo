package com.kausha.algo;

public class SpiralMatrixPrinting {

	public static void main(String[] args) {
		int[][] arr = {
					/*{1, 1, 1, 1},
					{2, 2, 2, 2},
					{3, 3, 3, 3},
					{4, 4, 4, 4},
					{5, 5, 5, 5}};*/
		/*
				{1, 1, 1, 1},
				{5, 5, 5, 5}};*/
				
				{1, 1},
				{2, 2},
				{3, 3},
				{4, 4},
				{5, 5}};
		spiralPrintingOfMatrix(arr);
	}
	
	private static void spiralPrintingOfMatrix(int[][] arr) {
		int left = 0;
		int right = arr[0].length-1;
		int top = 0;
		int bottom = arr.length-1;
		
		while(left <= right && top <= bottom) {
			if(left < right) {
				for(int i=left; i <= right; i++)
					System.out.println(arr[top][i]);
				top++;
			}
			
			if(top < bottom) {
				for(int i=top; i <=bottom; i++)
					System.out.println(arr[i][right]);
				right--;
			}
			
			if(left < right && bottom >= top) {
				for(int i=right; i >= left; i--)
					System.out.println(arr[bottom][i]);
				
				bottom--;
			}
			
			if(left <= right && top<=bottom) {
				for(int i=bottom; i >= top; i--) {
					System.out.println(arr[i][left]);
				}
				
				left++;
			}
		}
	}
}
