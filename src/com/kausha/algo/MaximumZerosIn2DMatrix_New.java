package com.kausha.algo;

public class MaximumZerosIn2DMatrix_New {
	public static void main(String[] args) throws Exception{
		int[][] arr = initializeMatrix();
		
		System.out.println(getRowWithMaxZero(arr));
	}
	
	private static int getRowWithMaxZero(int[][] arr) {
		int min = arr[0].length - 1;
		
		for(int i=0; i < arr.length; i++) {
			int localMin = getRowWithMaxZero(arr, i, min);
			
			if (localMin == -1)
				return i;
			
			if(localMin < min)
				min = localMin;
		}
		
		return arr[0].length - min;
	}

	private static int getRowWithMaxZero(int[][] arr, int row, int col) {
		if(arr[row][col] == 1)
			return col;
		
		int start = 0;
		int end = col;
		System.out.println("row = " + row + "   , col : " + col);
		while(start <= end) {
			int mid = start + (end-start)/2;
			
			if(arr[row][mid] == 0) {
				//proceed to left
				if(mid - 1 >= start && arr[row][mid-1] == 0) {
					end=mid-1;
				}else
					return mid;
			}else {
				start = mid+1;
			}
		}
		
		return -1;
	}

	private static int[][] initializeMatrix() {
		
		int[][] arr1 = {{
			1,1},{
				1,0}
			};
		int[][] arr = {{
			1, 1, 1, 0, 0},{
			1, 1, 1, 0, 0},{
			1, 1, 0, 0, 0},{
			1, 1, 0, 0, 0},{
			1, 1, 1, 0, 0},{
			//0, 0, 0, 0, 0},{
			1, 1, 1, 1, 1},{
			1, 1, 0, 0, 0}
			
		};
		
		return arr;
	}
}
