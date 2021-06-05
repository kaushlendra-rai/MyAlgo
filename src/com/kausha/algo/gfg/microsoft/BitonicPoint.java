package com.kausha.algo.gfg.microsoft;

public class BitonicPoint {
	public static void main(String[] args) {
		BitonicPoint bp = new BitonicPoint();
		int[] arr = new int[] {1,15,25,45,42,21,17,12,11};
		System.out.println(bp.findMaximum(arr, 9));

		int[] arr1 = new int[] {1,15,25,45};
		System.out.println(bp.findMaximum(arr1, 9));
		
		int[] arr2 = new int[] {12,11};
		System.out.println(bp.findMaximum(arr2, 9));
		
		int[] arr3 = new int[] {1, 100000, 500};
		System.out.println(bp.findMaximum(arr3, 9));
		
	}
	
	int findMaximum(int[] arr, int n) {
		if(arr.length == 1)
			return arr[0];
		
        int max = 0;
        //First lets check for array boundary
        if(arr[0] > arr[1])
        	return arr[0];
        if(arr[arr.length -2] < arr[arr.length-1])
        	return arr[arr.length-1];
        
        for(int i=1; i < arr.length-1; i++) {
        	if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
        		max = arr[i];
        		break;
        	}
        }
        
        return max;
    }

}
