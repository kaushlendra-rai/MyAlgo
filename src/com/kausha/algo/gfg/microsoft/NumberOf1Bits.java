package com.kausha.algo.gfg.microsoft;

public class NumberOf1Bits {

	public static void main(String[] args) {
		NumberOf1Bits nb = new NumberOf1Bits();
		System.out.println(nb.setBits(6));
		System.out.println(nb.setBits(1));
	}

	static int setBits(int N) {
        int count = 0;
        int one = 0;
        for(int i=0; i<32; i++) {
        	one = 1 << i;
        	if((one & N) > 0)
        		count++;
        }
        return count;
    }
}
