package com.kausha.algo.dp;

public class MinimumStepsJump {
	private static int minJumps(int[] arr) {  
	    int jumps[] = new int[arr.length];  // jumps[n-1] will hold the  
	                               // result 
	    int i, j; 
	           
	    if (arr == null || arr.length == 0 || arr[0] == 0) 
	         return Integer.MAX_VALUE;  // if first element is 0, 
	                                   // end cannot be reached 
	           
	    jumps[0] = 0; 
	           
	    // Find the minimum number of jumps to reach arr[i] 
	    // from arr[0], and assign this value to jumps[i] 
	    for (i = 1; i < arr.length; i++) 
	    { 
	        jumps[i] = Integer.MAX_VALUE; 
	         for (j = 0; j < i; j++) 
	         { 
	              if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) 
	              { 
	                  jumps[i] = Math.min(jumps[i], jumps[j] + 1); 
	                  break; 
	              } 
	          } 
	    } 
	        return jumps[arr.length-1]; 
	} 
	
	static int minJumps2(int arr[]) 
    { 
        if (arr.length <= 1) 
            return 0; 
  
        // Return -1 if not possible to jump 
        if (arr[0] == 0) 
            return -1; 
  
        // initialization 
        int maxReach = arr[0]; 
        int step = arr[0]; 
        int jump = 1; 
  
  
        // Start traversing array 
        for (int i = 1; i < arr.length; i++) 
        { 
            // Check if we have reached the end of the array 
            if (i == arr.length - 1) 
                return jump; 
  
            // updating maxReach 
            maxReach = Math.max(maxReach, i+arr[i]); 
  
            // we use a step to get to the current index 
            step--; 
  
            // If no further steps left 
            if (step == 0) 
            { 
                //  we must have used a jump 
                jump++; 
                   
                //Check if the current index/position  or lesser index 
                // is the maximum reach point from the previous indexes 
                if(i>=maxReach) 
                   return -1; 
  
                // re-initialize the steps to the amount 
                // of steps to reach maxReach from position i. 
                step = maxReach - i; 
            } 
        } 
  
        return -1; 
    } 
  
    // Driver method to test the above function 
    public static void main(String[] args) 
    { 
        int arr[] = new int[] {1, 3, 5, 18, 19, 2, 6, 7, 6, 8, 9}; 
  
        // calling minJumps method 
        System.out.println(minJumps(arr)); 
    }
}
