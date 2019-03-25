package com.kausha.algo;

public class MaximumZerosIn2DMatrix_New {
	public static void main(String[] args) throws Exception{
		int[][] arr = initializeMatrix();
		
		System.out.println(getRowWithMaxZero(arr));
	}
	
	private static int getRowWithMaxZero(int[][] arr) {
		int min = arr[0].length-1;
		
		for(int i = 0; i < arr.length; i++){
			int localMin = getRowWithMaxZero(arr, i, min);
			System.out.println("LocalMin = " + localMin);
			if(localMin == -1){
				min = -1;
				break;
			}
			
			if(localMin < min)
				min = localMin;
		}
		
		if(min >-1)
			return (arr[0].length - min - 1);
		else  
			return (arr[0].length);
	}

	private static int getRowWithMaxZero(int[][] arr, int row, int column) {
		if(arr[row][column] == 1)
			return column;
		
		int start = 0;
		int end = column-1;
		
		while(start <= end){
			int mid = start + (end-start)/2;
			
			if(arr[row][mid] == 1){
				if(mid+1 < arr[0].length && arr[row][mid+1] == 0){
					return mid;
				}else
					start = mid+1;
			}else{
				if(mid-1 >= 0 && arr[row][mid-1] == 1){
					return mid-1;
				}else
					end = mid-1;
			}
		}
		
		return -1;
	}

	private static int[][] initializeMatrix() {
		int[][] arr = {{
			1, 1, 1, 0, 0},{
			1, 1, 1, 0, 0},{
			1, 1, 0, 0, 0},{
			1, 1, 0, 0, 0},{
			0, 0, 0, 0, 0},{
			1, 1, 0, 0, 0}
			
		};
		
		return arr;
	}
}