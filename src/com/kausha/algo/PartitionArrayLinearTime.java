package com.kausha.algo;

/**
 * Partition array over 'index', such that numbers on left of index are smaller than the number on it's right
 *   
 * @author sinkar
 *
 */
public class PartitionArrayLinearTime {
	public static void main(String[] args) {
		int[] arr = {77, 1, 3, 89, 4, 75, 48, 42,36, 89, 222};
		int num = 6;
		partitionArray(arr, num);
		
		for(int i=0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

	}

	public static int partitionArray(int[] arr, int index) {
		int num = arr[index];
		int low = 0;
		int high = arr.length-1;
		int current = 0;
		
		while(low<high){
			if(arr[current] < num){
				low++;
				current++;
			}else if(arr[high] > num){
				high--;
			}else if(arr[current] > num){
				// Swap current & num at high
				int temp = arr[current];
				arr[current] = arr[high];
				arr[high] = temp;
				
				high--;
			}
		}
		
		return low;
	}

}
