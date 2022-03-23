package com.kausha.design.carparking;

public abstract class AbstractVehical implements Vehicle {
	VehicalType type;
	String displayName;
	String registrationNumber;
	
	@Override
	public VehicalType getType() {
		return type;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}
}
