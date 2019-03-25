package com.kausha.design.carparking;

public class MotorBike implements Vehicle {
	String type;
	String displayName;
	
	double hourlyPrice;

	@Override
	public String getType() {
		return "MotorBike";
	}

	@Override
	public String getDescription() {
		
		return "It could be MotorBike, or 4 wheeled handicap-enabled motor bike";
	}

	@Override
	public double getHourlyPrice() {
		
		return 5;
	}	
}