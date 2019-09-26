package com.kausha.algo;

/**
 * In a 2D with values 0 & 1
 * While parsing values in co-ordinates, if you encounter original '1', flip all the nodes in that row & column to '1'
 * If encountered '0', do not do anything
 * If encountered with '1' which was earlier '0', do not do anything.
 * 
 * Print the array after complete traversal
 * O(mn)
 * http://www.programcreek.com/2012/12/leetcode-set-matrix-zeroes-java/
 * @author sinkar
 *
 */
public class RuleBasedSwitch0And1In2D {

	public static void main(String[] args) {
		int arr[][] = getInitializedInputGrid();
		System.out.println("\nINPUT ::");
		for(int i = 0; i < arr.length; i++){
			for(int j=0; j < arr[0].length; j++){
					System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		parseArray(arr);
		
		System.out.println("\nOUTPUT ::");
		for(int i = 0; i < arr.length; i++){
			for(int j=0; j < arr[0].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void parseArray(int[][] arr){
		// First check if there is any 1 in the 1st row
		boolean setFirstRow = false;
		for(int i=0; i < arr[0].length; i++)
			if(arr[0][i] == 1){
				setFirstRow = true;
				break;
			}
		
		// First check if there is any 1 in the 1st column
		boolean setFirstColumn = false;
		for(int i=0; i < arr.length; i++)
			if(arr[i][0] == 1){
				setFirstColumn = true;
				break;
			}
		
		// Scan the rows and columns for 1 & mark the 0th ROW & COLUMN if any '1' exists there
		for(int i=1; i < arr.length; i++){
			for(int j=1; j < arr[0].length; j++){
				if(arr[i][j] == 1){
					arr[i][0] = 1;
					arr[0][j] = 1;
					//break;
				}
			}
		}
		
		for(int i=1; i < arr.length; i++){
			for(int j=1; j < arr[0].length; j++){
				if(arr[i][0] == 1 || arr[0][j] == 1){
					arr[i][j] = 1;
				}
			}
		}
		
		// Now Flip row & column based on 'setFirstRow' & 'setFirstColumn'
		if(setFirstRow){
			for(int i=0; i < arr[0].length; i++)
				arr[0][i] = 1;
		}
		
		if(setFirstColumn){
			for(int i=0; i < arr.length; i++)
				arr[i][0] = 1;
		}
			
	}

	private static int[][] getInitializedInputGrid() {
		int[][] grid = {{1, 0, 0, 0, 0, 0, 0, 1, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0},
						{1, 1, 0, 1, 0, 0, 0, 1, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0},
						{1, 1, 0, 0, 1, 0, 0, 0, 0}};
		
		return grid;
	}
}