package com.rai.kaushal.design.patterns.visitor;

public interface Item {

	void accept(Payment visitor);
}
