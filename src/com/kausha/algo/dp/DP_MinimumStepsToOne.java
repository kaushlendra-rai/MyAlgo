package com.kausha.algo.dp;

/**
 * http://www.codechef.com/wiki/tutorial-dynamic-programming#Problem_:_Minimum_Steps_to_One
 * 
 * Problem Statement: On a positive integer, you can perform any one of the following 3 steps. 
 * 1.) Subtract 1 from it. ( n = n - 1 )  , 
 * 2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2  )  , 
 * 3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ).
 * 
 * Now the question is, given a positive
 *  integer n, find the minimum number of steps that takes n to 1 eg: 
 *  1.) For n = 1 , output: 0       
 *  2.) For n = 4 , output: 2  ( 4  /2 = 2  /2 = 1 )    
 *  3.) For n = 7 , output: 3  (  7  -1 = 6   /3 = 2   /2 = 1 )
 *  4.) For n = 10, output: 3  (10 -1 = 9, 9/3 = 3, 3/3 = 1) 

 * @author sinkar
 *
 */
public class DP_MinimumStepsToOne {

	public static void main(String[] args) {
		getMinimumSteps(10);
	}
	
	private static void getMinimumSteps(int num){
		
		if(num == 1){
			System.out.println("0");
			return;
		}
		
		int[] arr = new int[num+1];
		arr[0] = 0; // Case for num = 1		
		arr[1] = 0;
		for(int i=2; i <=num; i++){
			int minDist = 1 + arr[i-1];
			
			if(i%2 == 0){
				if(minDist > (arr[i/2] + 1))
					minDist = arr[i/2] + 1;
			}
			
			if(i%3 == 0){
				if(minDist > (arr[i/3] + 1))
					minDist = arr[i/3] + 1;
			}
			
			arr[i] = minDist;
			
			System.out.println("i = " + i + "  ,    minDist = " + minDist);
		}
		
		System.out.println(arr[num]);
	}
}