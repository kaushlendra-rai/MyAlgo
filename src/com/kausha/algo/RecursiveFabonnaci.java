package com.kausha.algo;

public class RecursiveFabonnaci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(recursiveFabinnaci(0, 1, 2, 4));
		System.out.print("0, 1");
		printRecursiveFabinnaci(0, 1, 2, 5);
		// 0, 1, 1, 2, 3, 5, 8, ....
	}

	public static int recursiveFabinnaci(int first, int second, int counter, int maxNum){
		/*if(counter == 1){
			return ((first + second) + recursiveFabinnaci(first, second, 2, maxNum));
		}
		else if(counter == maxNum)
			return (first + second);
		*/

		if(counter == maxNum)
			return (first + second);
		else
			return ((first + second) + recursiveFabinnaci(second, first + second, counter+1, maxNum));
	}
	
	public static void printRecursiveFabinnaci(int first, int second, int counter, int maxNum){
		if(counter == maxNum){
			return;
		}else{
			System.out.print(", " + (first + second));
			printRecursiveFabinnaci(second, first + second, counter+1, maxNum);
		}
	}
}