package com.kausha.algo.gfg.microsoft;

public class MaximumXORSubArray {

	public static void main(String[] args) {
		//System.out.println(maxSubarrayXOR(4, new int[] {1,2,3,4})); // 7
		//System.out.println(maxSubarrayXOR(4, new int[] {1,3, 5, 8})); // 15
		System.out.println(maxSubarrayXOR(4, new int[] {3, 5, 8, 9, 11})); // 14
	}

	static int maxSubarrayXOR(int N, int arr[]){
		int maxXor = 0;
		int localXor = 0;
		int startIdx = 0;
		int counter = 0;
		
		while(counter < arr.length) {
			int temp = localXor ^ arr[counter];
			if(temp >= localXor) {
				localXor = temp;
				counter++;
				if(localXor > maxXor)
					maxXor = localXor;
			}else {
				localXor = localXor ^ arr[startIdx++];
				if(localXor > arr[counter])
					counter++;
			}
		}
		
		return maxXor;
    }
}