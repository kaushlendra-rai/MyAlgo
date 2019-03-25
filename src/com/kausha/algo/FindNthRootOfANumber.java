package com.kausha.algo;

public class FindNthRootOfANumber {
	public static void main(String[] args) {
		System.out.println(getNthRoot(9, 2 ));
	}
	
	public static double getNthRoot(int number, int root){
		if(number < 1 || root < 1)
			throw new IllegalArgumentException("wrong values");
		
		if(root == 1)
			return number;
		
		double nthRoot = number;
		
		double start = 0;
		double end = number;
		
		int decimalItrCounter = 0;
		int MAX_ITR_COUNT = 20;
		double mid = 0;
		
		while(start < end){
			mid = start + (end-start)/2;
			System.out.println("mid = " + mid);
			// match has been found
			if(number == Math.pow(mid, root)){
				return mid;
			}else if(number > Math.pow(mid, root)){
				start = mid;
			}else
				end = mid;
			
			if(end-start < 1){
				if(decimalItrCounter < MAX_ITR_COUNT)
					decimalItrCounter++;
				else
					return mid;
			}
		}
		
		return nthRoot;
	}
}