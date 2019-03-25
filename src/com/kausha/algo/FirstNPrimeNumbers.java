package com.kausha.algo;

public class FirstNPrimeNumbers {
	public static void main(String[] args) {
		int[] primeNumberArray = printFirstNPrimeNumbers(3);

		for(int primeNum : primeNumberArray)
			System.out.println(primeNum);
	}

	private static int[] printFirstNPrimeNumbers(int size) {
		if(size <1)
			return new int[0];
		
		int[] primes = new int[size];
		
		if(size > 0)
			primes[0] = 2;
		
		int num = 3;
		int counter = 1;
		while(counter < size){
			boolean isPrime = true;
			for(int i=0; i < counter; i++){
				if(num%primes[i] ==0){
					isPrime = false;
					break;
				}
			}
			
			if(isPrime)
				primes[counter++] = num;
			
			num+=2;
		}
		
		return primes;
	}
}
