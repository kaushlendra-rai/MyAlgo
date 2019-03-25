package com.rai.kaushal.design.patterns.visitor;

public class Buyer implements Payment {

	@Override
	public void pay(ElectronicGoods item) {
		System.out.println(" ElectronicGoods  item = " + item.getDescription());
	}

	@Override
	public void pay(Grocessary item) {
		System.out.println(" Grocessary  item = " + item.getDescription());
	}

	@Override
	public void pay(Stationary item) {
		System.out.println(" Stationary  item = " + item.getDescription());
	}
}