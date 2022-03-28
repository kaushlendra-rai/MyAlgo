package com.kausha.design.carparking;

public abstract class AbstractVehicle implements Vehicle {
	VehicleType type;
	String displayName;
	String registrationNumber;
	
	@Override
	public VehicleType getType() {
		return type;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}
}
