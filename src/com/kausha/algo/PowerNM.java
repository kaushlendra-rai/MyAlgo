package com.kausha.algo;

public class PowerNM {

	public static void main(String[] args) {
		System.out.println(powerNM(2, -3));

	}

	public static double powerNM(int n, int m) {
		boolean negative = false;
		boolean even = true;
		
		if(m <0)
			negative = true;
		int mAbs = Math.abs(m);
		if(mAbs %2 ==1) {
			mAbs = mAbs-1;
			even = false;
		}
		
		int num = power(n, mAbs);
		if(!even)
			num = num * n;
		System.out.println("num = " + num);
		if(negative)
			return (double)1/num;
		else
			return (double)num;
	}

	private static int power(int n, int m) {
		if(m == 0)
			return 1;
		if(m==1)
			return n;
		int pow = power(n, m/2);
		
		return pow * pow;
	}
}
