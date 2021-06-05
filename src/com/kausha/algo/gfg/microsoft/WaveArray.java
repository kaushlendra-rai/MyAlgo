package com.kausha.algo.gfg.microsoft;

public class WaveArray {

	public static void main(String[] args) {
		WaveArray wa = new WaveArray();
		int[] arr = new int[] {1,2,3,4,5};
		wa.convertToWave(arr, arr.length);
		for(int num : arr)
			System.out.print(" " + num);
	}

	public static void convertToWave(int arr[], int n){
        if(arr == null)
        	return;
        
        for(int i=1; i<n; i+=2) {
        	int temp = arr[i];
        	arr[i] = arr[i-1];
        	arr[i-1] = temp;
        }
    }
}
