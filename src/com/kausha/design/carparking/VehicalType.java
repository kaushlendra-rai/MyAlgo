package com.kausha.design.carparking;

public enum VehicalType {
	SMALL(10), MEDIUM(20), LARGE(30), EXTRALARGE(40);
	
	int size;
	
	VehicalType(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
}
