package com.kausha.algo;

public class NextLargerNumberWithNoConsecutiveOne {
	public static void main(String[] args) {
		int num = 11; // 1011  ->  1100 -> 10000
		System.out.println("Input num = " + num);
		int nextNumber = getNextLargerNum(num);
		System.out.println("\nnextNumber = " + nextNumber);
	}

	private static int getNextLargerNum(int num) {
		
		int nextLarger = nextLarger(num);
		
		if(num == nextLarger)
			nextLarger = nextLarger(num+1);
		
		return nextLarger;
	}

	private static int nextLarger(int num) {
		int nextLarger = 0;
		
		int[] bits = new int[32];
		int counter = 1;
		for(int i=0; i< 32; i++){
			if((num & counter) >0)
				bits[i] = 1;
			counter = counter << 1;
		}
		
		counter = 0;
		
		for(int i=0; i < 32; i++){
			if(counter == 1 && bits[i] == 1){
				bits[i] = 0;
			}else if(i  < 31 && ((bits[i] & bits[i+1]) == 1 || (counter & bits[i+1]) == 1)){
				counter = 1;
				bits[i] = bits[i+1] = 0;
				i++;
			}else if(counter == 1){
				bits[i] = 1;
				counter = 0;
			}
		}
		
		counter =1;
		for(int i=0; i< 32; i++){
			if(bits[i] == 1)
				nextLarger += counter;
			counter = counter << 1;
		}
		
		return nextLarger;
	}
}