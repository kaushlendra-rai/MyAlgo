package com.kausha.design.carparking;

public class ParkingLot {

	// Check if parking is supported only for 'Cars' or even extended to Bikes, Cars, Trucks, cycle, etc.
	private Vehicle type;
	
	// BuildingId in case if parking is spread across multiple buildings 
	private String siteId;
	private int x;
	private int y;
	private int floor;
	
	boolean handicapEnabled;
	
	// It might be required to disable certain parking lot, floor or the entire building due to maintenance reasons.
	// Hence such parking lots must not be visible to the system.
	boolean active;
	
	// Unique identifier in case of split parking at same location (One on top of other mechanically)
	private int id;

}
