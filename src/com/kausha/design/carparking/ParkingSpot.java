package com.kausha.design.carparking;

public class ParkingSpot {

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

	public Vehicle getType() {
		return type;
	}

	public void setType(Vehicle type) {
		this.type = type;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public boolean isHandicapEnabled() {
		return handicapEnabled;
	}

	public void setHandicapEnabled(boolean handicapEnabled) {
		this.handicapEnabled = handicapEnabled;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
