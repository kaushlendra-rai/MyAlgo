package com.rai.kaushal.design.patterns.visitor;

public class TestVisitor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Payment payment = new Buyer();

		ElectronicGoods eg = new ElectronicGoods();
		Stationary st = new Stationary();
		
		eg.accept(payment);
		st.accept(payment);
	}
}