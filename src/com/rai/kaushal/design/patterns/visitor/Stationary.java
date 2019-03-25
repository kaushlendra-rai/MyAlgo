package com.rai.kaushal.design.patterns.visitor;

public class Stationary implements Item {

	@Override
	public void accept(Payment payment) {
		payment.pay(this);
	}

	public String getDescription() {
		return "I'm an Stationary Section. Books, pen, etc.";
	}
}