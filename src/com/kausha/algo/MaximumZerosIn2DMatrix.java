package com.kausha.algo;


/**
 *   
 *    	0 1 2 3 4
 *    
 *	0	1 1 0 0 0
 *	1 	1 1 1 0 0 
 *	2 	1 0 0 0 0
 *	3 	1 1 0 0 0
 *
 * @author sinkar
 *
 */
public class MaximumZerosIn2DMatrix {
	
	public static void main(String[] args) throws Exception{
		int[][] arr = initializeMatrix();
		
		System.out.println(getRowWithMaxZero(arr, arr.length-1, arr[0].length-1));
	}
	
	public static int getRowWithMaxZero(int[][] arr, int row, int column) throws Exception{
	     if(arr == null)
	         throw new Exception("Array is null");
	     
	     int indexForOne = 0;
	     int rowNum = 0;
	     int start = 0;
         int end = column;
         
         // Tests for Row 1 only indexed at '0' row
         int indexForOneTemp = findMidPoint(arr, 0, start, end);
         
         // All values in the row were 1
         if(indexForOneTemp == 0 && arr[0][0] == 1)
             indexForOne  = column;
         else if(indexForOneTemp == 0 && arr[0][0] == 0) // All values in the row were 0
             indexForOne   = 0;
         else
        	 indexForOne = indexForOneTemp;
         
         // Process for 2nd row onwards
	     for(int i = 1; i <= row; i++){
	         start = 0;
	         end = indexForOne;

	        if(arr[i][end] == 1)
	            continue;
	            
	        indexForOne = findMidPoint(arr, i, start, end);
	        rowNum  = i;
	     }
	     
	     return rowNum ;
	 }

	
	private static int findMidPoint(int[][] arr, int rowNum, int start, int end){
		int indexForOne = 0;
		
		while(start < end){
            int mid = start + (end - start)/2;
            
            // If break point found, get the index and break
            if(arr[rowNum][mid] == 1 && arr[rowNum][mid + 1] ==0){
                indexForOne = mid;
                break;
            }else if(arr[rowNum][mid] == 1)
                start = mid + 1;
            else
                end = mid;
        }
		
		return indexForOne;
	}
	
	private static int[][] initializeMatrix() {
		int[][] arr = {{
			1, 1, 1, 0, 0},{
			1, 1, 1, 0, 0},{
			1, 1, 0, 0, 0},{
			1, 1, 0, 0, 0},{
			1, 1, 0, 0, 0}
			
		};
		
		return arr;
	}
}