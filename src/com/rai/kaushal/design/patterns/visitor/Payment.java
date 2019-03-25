package com.rai.kaushal.design.patterns.visitor;

public interface Payment {

	void pay(ElectronicGoods item);
	
	void pay(Grocessary item);
	
	void pay(Stationary item);
}