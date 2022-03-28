package com.kausha.design.carparking;

// Depending on the car-type, set the price for each category.
public class DefaultPricingStrategy {
	// Each site can have a different price due to it's locality and city.
	// Hence, the hourly price must include parking spot into consideration.
	public double getHourlyPrice(VehicleType type, ParkingSpot parkingSpot) {
		return 0;
	}
}
