package com.kausha.design.elevator;

public class CarDisplay {
	int floor;
	Direction direction;
	boolean overWeight;
	
	public String show() {
		if(overWeight)
			return "Weight limit exceeded. Someone must move out of the lift";
		else
			return "Floor: "+ floor + ", direction: " + direction.name();
	}
	
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public void setOverWeight(boolean overWeight) {
		this.overWeight = overWeight;
	}
}
