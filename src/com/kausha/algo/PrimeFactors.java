package com.kausha.algo;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
		/**Primefactors are the prime numbers that divide the number perfectly
		 * @param args
		 */
		public static void main(String[] args) {
			System.out.println(primeFactors(21, 2, new ArrayList<Integer>()));

		}
		
		public static List<Integer> primeFactors(int num, int divisor, List<Integer> list)
		{
			if(num == 1 || Math.sqrt(num) < divisor)
			{
				list.add(num);
				return list;
			}
			
			if(num%divisor == 0)
			{
				list.add(divisor);
				return primeFactors(num/divisor, divisor, list);
			}
			
			if(divisor == 2)
				return primeFactors(num, divisor+1, list);
			else
				return primeFactors(num, divisor+2, list);
		}

	}