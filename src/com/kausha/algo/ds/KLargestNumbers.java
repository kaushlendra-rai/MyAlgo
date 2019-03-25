package com.kausha.algo.ds;

public class KLargestNumbers {
	public static void main(String[] args) {
		int[] arr = {2, 5, 345, 87, 3, 567, 45, 476, 978, 23, 45, 74, 445, 22, 45, 97, 43, 21};
		int k = 5;
		
		int[] largest = getKLargestElements(arr, k);
		
		for(int i =1; i <= k; i++){
			System.out.println(largest[i] + ", ");
		}
	}
	
	private static int[] getKLargestElements(int[] arr, int k){
		// We do NOT access index '0' for sake of simplicity - n -> 2n & 2n+1
		int[] largest = new int[k + 1];
		
		// Maintain a MIN-HEAP of size 'k'. If the heap is full, replace the TOP node of the heap 
		// with the new value from array if it is larger than the TOP node. 
		// The final set of heap would be 'K' largest numbers.
		int minHeapCount = 1;
		
		for(int i = 0; i < arr.length; i++){
			minHeapCount = minHeapify(arr[i], k, largest, minHeapCount);
		}
		
		return largest;
	}

	private static int minHeapify(int value, int k, int[] largest, int minHeapCount) {
		int org = minHeapCount;
		if(minHeapCount <= k){
			// Build heap from bottom
			largest[minHeapCount] = value;
			//System.out.println("***********");
			// now check if this satisfies MIN-HEAP property
			//Swap if child is smaller than parent and propagate swaps till the root
			while(largest[minHeapCount/2] > largest[minHeapCount] && minHeapCount > 1){
				swap(largest, minHeapCount, minHeapCount/2);
				minHeapCount = minHeapCount/2;
				//System.out.println("In");
			}
			
			//minHeapCount++;
			org++;
		}else{
			// Heap is FULL, check the new value with the ROOT node value.
			// If it is larger than it, replace the top value with new value
			// Restore MIN-HEAP property by percolating DOWN the HEAP.
			
			if(value > largest[1]){
				int current = 1;
				largest[1] = value;
				while(current*2 <= k){
					if(current*2 <= k && largest[current*2]  <= largest[current]){
						swap(largest, current, current*2);
						current = current*2;
					}else if(current*2 + 1 <= k && largest[current*2 + 1]  <= largest[current]){
						swap(largest, current, current*2 + 1);
						current = current*2 + 1;
					}else
						break;
				}
			}
		}
		
		return org;
	}
	
	private static void swap(int[] arr, int first, int second){
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
}