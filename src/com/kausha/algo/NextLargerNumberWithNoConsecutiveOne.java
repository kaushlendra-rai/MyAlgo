package com.kausha.algo;

public class NextLargerNumberWithNoConsecutiveOne {
	public static void main(String[] args) {
		//int num = 11; // 1011  ->  1100 -> 10000
		//int num = 9; // 1011  ->  1100 -> 10000
		int num = 3; // 1011  ->  1100 -> 10000
		System.out.println("Input num = " + num);
		int nextNumber = getNextLargerNum(num);
		System.out.println("\nnextNumber = " + nextNumber);
	}

	private static int getNextLargerNum(int num) {

		// Ideally we need to check
		// 1) If there are two consecutive '1', resolve by below logic.
		// 2) If not, add '1' to above number and repeat the steps. Final number is the answer.
		int nextLarger = nextLarger(num);
		
		// Step 2
		if(num == nextLarger)
			nextLarger = nextLarger(num+1);
		
		return nextLarger;
	}

	private static int nextLarger(int num) {
		int nextLarger = 0;
		// Convert the number to integer array
		int[] bits = new int[32];
		int counter = 1;
		for(int i=0; i< 32; i++){
			if((num & counter) >0)
				bits[i] = 1;
			counter = counter << 1;
		}
		// Carry forward
		int carry = 0;
		// Find next number without consecutive '1'.  If there are no consecutive '1',
		// the below code returns the same number.
		for(int i=0; i < 32; i++){
			if(carry == 1 && bits[i] == 1){
				bits[i] = 0;
			}else if(i  < 31 && ((bits[i] & bits[i+1]) == 1 || (carry & bits[i+1]) == 1)){
				carry = 1;
				bits[i] = bits[i+1] = 0;
				i=i+1;
			}else if(carry == 1){
				bits[i] = 1;
				carry = 0;
			}
		}
		// Get the resulting number from the representing array.
		carry =1;
		for(int i=0; i< 32; i++){
			if(bits[i] == 1)
				nextLarger += carry;
			carry = carry << 1;
		}
		
		return nextLarger;
	}
}