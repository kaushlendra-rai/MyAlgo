package com.kausha.design.elevator;

public abstract class Button implements Command{
	int floor;
	ElevatorCar car;
	
	public Button(int floor, ElevatorCar car) {
		this.floor = floor;
		this.car = car;
	}
}
