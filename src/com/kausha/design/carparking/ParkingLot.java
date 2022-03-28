package com.kausha.design.carparking;

import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ParkingLot {
	int siteId;
	int zipcode; // Zipcode can be helpful in searching parking lots through an app.
	
	int rows;
	int columns;
	int floors;

	ConcurrentMap<VehicleType, Stack<ParkingSpot>> availableParking = new ConcurrentHashMap<>();
	ConcurrentMap<String, ParkingSpot> reservations = new ConcurrentHashMap<>();
	// All available parking spots for each category should be maintained in a Stack/Queue
	public ParkingSpot bookParkingSpot(Vehicle vehicle, Customer customer) {
		Stack<ParkingSpot> availableSpots = availableParking.get(vehicle.getType());
		
		ParkingSpot spot = null;
		if(!availableSpots.isEmpty())
			spot = availableSpots.pop();
		
		reservations.put(vehicle.getRegistrationNumber(), spot);
		return spot;
	}
	
	public void releaseParkingSpot(ParkingTicket ticket) {
		ParkingSpot spot = ticket.parkingSpot;
		Stack<ParkingSpot> availableSpots = availableParking.get(spot.getType());
		availableSpots.push(spot);
		reservations.remove(ticket.vehical.registrationNumber);
	}
}
