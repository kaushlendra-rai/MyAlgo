package com.kausha.design.onlineReservation;

import java.util.Date;
import java.util.List;

public class ReservationService implements Reservation {

	@Override
	public List<Restaurant> getAvailableResturants(String filter) {
		
		return null;
	}

	@Override
	public String reserveSeats(String resturantId, String userId, Date date, TimeSlot slot, int groupSize)
			throws UnableToReserveSeats {
		
		return null;
	}

	@Override
	public boolean cancelReservation(String reservationId, String userId) {
		
		return false;
	}

	@Override
	public void notifyReservationStatus(String userId, String reservationId, String status) {
		

	}

}
