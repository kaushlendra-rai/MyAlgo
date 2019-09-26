package com.kausha.design.onlineReservation;

public enum TimeSlot {
	TwelvePM("12:00-02:00 PM"), TwoPM("02:00-03:30 PM");
	
	String value;
	private TimeSlot(String value) {
		this.value = value;
	}
}
