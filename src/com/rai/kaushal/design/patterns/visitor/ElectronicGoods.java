package com.rai.kaushal.design.patterns.visitor;

public class ElectronicGoods implements Item {

	@Override
	public void accept(Payment payment) {
		payment.pay(this);
	}

	public String getDescription() {
		return "I'm an ElectronicGoods Section. Mobiles, Camera & lots of stuffs.";
	}
}