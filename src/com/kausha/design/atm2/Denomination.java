package com.kausha.design.atm2;

public enum Denomination {
	Hundred(100), TwoHundred(200), FiveHundred(500), TwoThousand(2000);

	public final int value;
	private Denomination(int value) {
		this.value = value;
	}
}
