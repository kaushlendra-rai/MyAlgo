package com.kausha.algo;

public class FindRepeatingNumbersIn1ToNArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = {1, 2, 3, 2, 5, 7, 9, 2, 4, 5};

		findRepeatingNumbers(num);
	}

	private static void findRepeatingNumbers(int[] num) {
		for(int i=0; i < num.length; i++){
			int index = num[i] % num.length;
			
			num[index] += num.length;
		}
		
		for(int i=0; i < num.length; i++){
			if(num[i] > 2*num.length)
				System.out.println(i);
		}
	}

}
