package com.kausha.algo;

public class FindMissingIntegerFromFileOfNumbers {
	private static int[] array = null;
	private static int[] numArray = null;
	
	public static void main(String[] args) {
		int maxNumbers = 11155;
		
		array = new int[(maxNumbers/32) + 1];
		numArray = new int[maxNumbers];
		
		for(int i = 0; i < maxNumbers; i++){
			if(i < 66)
				numArray[i] = i;
			else
				numArray[i] = i+1;
		}
		
		for(int num : numArray)
			populateArrayWithNumber(num);

		System.out.println("MissingNumber = " + findMissingNumber());
	}

	private static void populateArrayWithNumber(int number){
		int numberBlock = number/32;
		int bitNumber = number%32;
		
		int n = 1;
		for(int i=0; i < bitNumber; i++){
			n = n<<1;
		}
		
		array[numberBlock] = array[numberBlock]  | n;
	}
	
	private static int findMissingNumber(){
		int missingNumber = 0;
		int residual = 0;
		int blockCount = 0;
		
		for(int i = 0; i < array.length; i++){
			if(-1 != array[i]){
				int internalCounter = 1;
				
				for(int j=0; j < 32; j++){
					if((array[i] & internalCounter) == 0){
						residual = j;
						break;
					}else
						internalCounter = internalCounter << 1;
				}
				
				blockCount = i;
				break;
			}
		}
		
		missingNumber = 32 * blockCount + residual;
		
		return missingNumber;
	}
}