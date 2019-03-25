package com.rai.kaushal.design.patterns.visitor;

public class Grocessary implements Item {

	@Override
	public void accept(Payment payment) {
		payment.pay(this);
	}

	public String getDescription() {
		return "I'm an Grocessary Section. Daal, Chawal, sugar, etc.";
	}
}