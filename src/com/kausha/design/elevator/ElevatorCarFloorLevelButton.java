package com.kausha.design.elevator;

// Depending on the floor value being 1, 2, 3, etc., same class would be representing the different buttons with 
// different state. For an Elevator car, the button panel will have a list of these button instances.
public class ElevatorCarFloorLevelButton extends Button {
	
	public ElevatorCarFloorLevelButton(int floor, ElevatorCar car) {
		super(floor, car);
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
