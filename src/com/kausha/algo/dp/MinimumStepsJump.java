package com.kausha.algo.dp;

public class MinimumStepsJump {
	private static int minJumps(int[] arr) {
		if (arr == null || arr.length == 0 || arr[0] == 0) 
	         return Integer.MAX_VALUE;  // if first element is 0, end cannot be reached 
		
		int jumps[] = new int[arr.length];  // jumps[n-1] will hold the result
		int i, j;
	    jumps[0] = 0; 

	    // Find the minimum number of jumps to reach arr[i] 
	    // from arr[0], and assign this value to jumps[i]
	    for (i = 1; i < arr.length; i++) {
	        jumps[i] = Integer.MAX_VALUE;
	         for (j = 0; j < i; j++) {
	              if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
	                  jumps[i] = Math.min(jumps[i], jumps[j] + 1);
	                  break;
	              }
	          }
	    }
	    return jumps[arr.length-1]; 
	}

	// Driver method to test the above function 
    public static void main(String[] args) { 
        int arr[] = new int[] {1, 3, 5, 18, 19, 2, 6, 7, 6, 8, 9}; 

        // calling minJumps method 
        System.out.println(minJumps(arr)); 
    }
}
