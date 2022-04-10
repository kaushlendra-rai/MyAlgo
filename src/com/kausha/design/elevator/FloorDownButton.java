package com.kausha.design.elevator;

// The FloorButtons would be associated to the central controller.
// The intent of going UP or DOWN from the floor button would be dispatched to this controller.
public class FloorDownButton extends Button {
	public FloorDownButton(int floor, ElevatorCar car) {
		super(floor, car);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
