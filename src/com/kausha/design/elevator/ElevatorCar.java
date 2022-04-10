package com.kausha.design.elevator;

import java.util.List;
import java.util.Set;

public class ElevatorCar {
	int currentWeight;
	int maxAllowedWeight;
	
	ElevatorState state;
	
	CarDisplay display;
	List<Button> panel;
	
	Direction direction;
	
	Set<Integer> stops;
	
	public void move() {
		
	}
	
	// If the state of the car is STOPPED, and again a STOP event/call is received, it implies that the door MUST OPEN again.
	public void stop() {
		
	}
}
