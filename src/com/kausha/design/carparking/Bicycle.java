package com.kausha.design.carparking;

public class Bicycle implements Vehicle {
	String type;
	String displayName;
	
	double hourlyPrice;

	@Override
	public String getType() {
		return "Bicycle";
	}

	@Override
	public String getDescription() {
		
		return "Bicycles";
	}

	@Override
	public double getHourlyPrice() {
		
		return 2;
	}	
}