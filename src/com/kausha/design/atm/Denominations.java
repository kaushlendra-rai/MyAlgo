package com.kausha.design.atm;

public enum Denominations {
	FIFTY(50), HUNDRED(100), FIVEHUNDRED(500), TWOTHOUSAND(2000);
	int value;

	private Denominations(int value){
		this.value = value;
	}
}
