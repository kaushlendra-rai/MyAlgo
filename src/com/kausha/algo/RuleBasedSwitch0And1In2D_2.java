package com.kausha.algo;

/**
 * In a 2D with values 0 & 1
 * While parsing values in co-ordinates, if you encounter original '1', flip all the nodes in that row & column to '1'
 * If encountered '0', do not do anything
 * If encountered with '1' which was earlier '0', do not do anything.
 * 
 * Print the array after complete traversal
 * O(mn)
 * @author sinkar
 *
 */
public class RuleBasedSwitch0And1In2D_2 {

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
		
		/*System.out.println("\nOUTPUT ::");
		for(int i = 0; i < arr.length; i++){
			for(int j=0; j < arr[0].length; j++){
					System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}*/
		
		System.out.println("\nOUTPUT ::");
		for(int i = 0; i < arr.length; i++){
			for(int j=0; j < arr[0].length; j++){
				if(arr[i][j] > 0)
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
	}

	private static void parseArray(int[][] arr){
		// Number Encoding used:
		// 0 - Original 0
		// 1 - Original 1
		// 2 - Column has been flipped for this element which had value '1'
		// 3 - Row has been flipped for this element which had value '1'
		// 4 - Row and Column have been flipped for this element which had value '1'
		// 5 - '0' has been flipped because it was in row/column having '1'
		for(int i = 0; i < arr.length; i++){
			for(int j=0; j < arr[0].length; j++){
				if(arr[i][j] == 1){
					flip(arr, i, j, true, true);
				}else if(arr[i][j] == 2){
					flip(arr, i, j, false, true);
				}else if(arr[i][j] == 3){
					flip(arr, i, j, true, false);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 * @param b If Column needs to be flipped
	 * @param c If Row needs to be flipped
	 */
	private static void flip(int[][] arr, int i, int j, boolean b, boolean c) {
		if(b){
			for(int k=0; k < arr[0].length; k++){
				if(arr[i][k] == 0)
					arr[i][k] = 5;
				else if(arr[i][k] == 1)
					arr[i][k] = 2;
				else if(arr[i][k] == 3)
					arr[i][k] = 4;
			}
		}
		
		if(c){
			for(int k=0; k < arr.length; k++){
				if(arr[k][j] == 0)
					arr[k][j] = 5;
				else if(arr[k][j] == 1)
					arr[k][j] = 3;
				else if(arr[k][j] == 2)
					arr[k][j] = 4;
			}
		}
	}

	private static int[][] getInitializedInputGrid() {
		int[][] grid = {{1, 0, 0, 0, 0, 0, 1, 1, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0},
						{1, 1, 0, 1, 0, 0, 0, 1, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0},
						{1, 1, 0, 0, 1, 0, 0, 0, 0}};
		
		return grid;
	}
}