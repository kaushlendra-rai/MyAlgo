package com.kausha.algo.gfg.microsoft;

public class SumTwoNumberWithoutArithmeticOperator {

	public static void main(String[] args) {
		SumTwoNumberWithoutArithmeticOperator sum = new SumTwoNumberWithoutArithmeticOperator();
		//System.out.println(sum.sum(4, 8));
		//System.out.println(sum.sum(14, 28));
		//System.out.println(sum.sum(2, 6)); // 8
		System.out.println(sum.sum(10, 30));
	}

	int sum(int a , int b)
    {
		int sum = 0;
		int num = 1;
		int carry = 0;
		for(int i=0; i<32; i++) {
			int andNum = num << i;
			int a1 = a & andNum;
			int b1 = b & andNum;
			if(a1 > 0 && b1 > 0) {
				if(carry == 0)
					carry = 1;
				else {
					sum = sum | andNum;
				}
			}else if((a1 | b1) > 0 && carry == 1){
				carry = 1;
			}else if(((a1 | b1) > 0 && carry ==0) || carry ==1) {
				sum = sum | andNum;
				carry = 0;
			}
		}
        return sum;
    }
}
