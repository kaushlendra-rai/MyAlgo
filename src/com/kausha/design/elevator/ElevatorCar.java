package com.kausha.design.elevator;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ElevatorCar {
	public ElevatorCar() {
		currentFloor = 0;
		direction = Direction.UP;
	}
	int currentWeight;
	int maxAllowedWeight;
	
	boolean maintenanceHalt;
	ElevatorState state;
	
	CarDisplay display;
	List<Button> panel;
	
	Direction direction;
	
	Set<Integer> stops;
	
	int currentFloor;
	TreeSet<Integer> up = new TreeSet<>();
	TreeSet<Integer> down = new TreeSet<>();
	
	public void move() {
		while(!maintenanceHalt) {
			outer:
			// check if there are any requests for lift. If yes, only then move, else stay.
			if(!up.isEmpty() || !down.isEmpty()) {
				if(direction == Direction.UP && !up.isEmpty()) {
					int floor = up.pollFirst();
					for(int i=currentFloor; i<= floor; i++) {

						// BroadCast this value to the Floor Displays that are associated to this ElevatorCar so that 
						// they could show the floor at which the lift is at this moment.
						notifyFloorDisplays();
						
						//Though this loop helps in displaying the movement of lift across the floors, if there is a new request
						// just added, I need to add logic to check if there is a new floor just added which is between the current floor and the 
						// target 'floor' and halt if required.
						if(up.first() < floor) {
							// New request found, add the earlier floor back in request and break the loop.
							up.add(floor);
							break outer;
						}
					}
					currentFloor = floor;
					
					openElevatorDoors();
					// If this is the last floor in this direction, we need to switch the direction.
					if(up.isEmpty()) {
						direction = Direction.DOWN;
					}
				}
				
				if(direction == Direction.DOWN && !down.isEmpty()) {
					int floor = down.pollLast();
					currentFloor = floor;
					
					// ###########
					// ############   DO SOMETHING SIMILAR AS "up" FLOW FOR LOOP AND BREAK FOR NEW REQUESTS ADDED.
					// ###########
					
					// BroadCast this value to the Floor Displays that are associated to this ElevatorCar so that 
					// they could show the floor at which the lift is at this moment.
					notifyFloorDisplays();
					openElevatorDoors();
					// If this is the last floor in this direction, we need to switch the direction.
					if(down.isEmpty()) {
						direction = Direction.UP;
					}
				}
			}
			
			
		}
	}
	
	// If more requests come for the current floor while lift is still open, stay open and update the EvevatorCar State appropriately
	public void openElevatorDoors() {
		try {
			System.out.println("Opening the door");
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			System.out.println("Interrupted");
		}
		
	}

	private void notifyFloorDisplays() {
		System.out.println("Current floor: " + currentFloor);
	}
	public void addStop(int floorNum) {
		// Set the direction of Lift if it was stationary/idle when the request came.
		if(up.isEmpty() && down.isEmpty()) {
			if(currentFloor > floorNum)
				direction = Direction.DOWN;
			else
				direction = Direction.UP;
		}
		if(currentFloor > floorNum)
			down.add(floorNum);
		else
			up.add(floorNum);
		
		
	}
	
	// If the state of the car is STOPPED, and again a STOP event/call is received, it implies that the door MUST OPEN again.
	public void stop() {
		
	}
}
