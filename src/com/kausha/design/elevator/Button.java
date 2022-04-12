package com.kausha.design.elevator;

public abstract class Button implements Command{
	int floor;
	int displayValue; // -1 can have display value Basement, 0 can have groundfloor, etc.
	ElevatorCar car;
	
	public Button(int floor, ElevatorCar car) {
		this.floor = floor;
		this.car = car;
	}
}
