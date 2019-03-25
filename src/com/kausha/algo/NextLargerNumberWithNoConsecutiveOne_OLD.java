package com.kausha.algo;

public class NextLargerNumberWithNoConsecutiveOne_OLD {
	public static void main(String[] args) {
		//int num = 11; // 1011  ->  1100 -> 10000
		int num = 5; 
		System.out.println("Input num = " + num);
		int nextNumber = getNextLargerNum(num);
		System.out.println("\nnextNumber = " + nextNumber);
	}

	private static int getNextLargerNum(int num) {
		int[] bits = new int[32];
		int index = 0;
		while(num != 0){
			bits[index++] = num & 1;
			num = num>>1;
		}
		
		for(int i=0; i < bits.length; i++)
			System.out.print(bits[i] + " ");
		
		for(int i=0; i < bits.length-1; i++){
			if((bits[i] == 1 && bits[i+1] == 1)){
				for(int j = i; j < bits.length; j++){
					if(bits[j] == 1)
						bits[j]=0;
					else{
						bits[j] = 1;
						i = j-1;
						break;
					}
				}
			}
		}
		
		System.out.println("\nOutput : ");
		num = 0;
		for(int i=0; i < bits.length; i++){
			System.out.print(bits[i] + " ");
			if(bits[i] == 1)
				num = num + (int)Math.pow(2, i);
		}
		
		return num;
	}
}