package com.kausha.design.onlineReservation;

import java.util.Date;
import java.util.List;

public interface Reservation {
	List<Restaurant> getAvailableResturants(String filter);
	String reserveSeats(String resturantId, String userId, Date date, TimeSlot slot, int groupSize) throws UnableToReserveSeats;
	boolean cancelReservation(String reservationId, String userId);
	
	void notifyReservationStatus(String userId, String reservationId, String status); // Send email and SMS for confirmation
	
}
