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
		System.out.println("Final location of partition pivot: " + partitionArray(arr, num));
		
		for(int i=0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	public static int partitionArray(int[] arr, int index) {
		int num = arr[index];
		System.out.println("Pivot element: " + num);
		int low = 0;
		int high = arr.length-1;
		
		while(low<high){
			if(arr[low] < num){
				low++;
			}else if(arr[high] > num){
				high--;
			}else if(arr[low] > num){
				// Swap current & num at high
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
		}
		
		return low;
	}
}
