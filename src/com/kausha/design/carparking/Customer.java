package com.kausha.design.carparking;

/**
 * Customer details would be useful in case if customer looses the card and comes back to claim the car based only with vehical 'key'.
 * Here, now the customer could be asked to show the ID which was registered at the time of booking parking lot.
 * @author sinkar
 *
 */
public class Customer {
	String customerId;
	
	String firstName;
	String middleName;
	String lastName;
	
	// Driving License, PAN, SSN, Aadhar, passport, etc
	String idType;
	String idValue;
	
	String mobileNumber; // This could be used to send an bill amount, send parking location details, etc. to the customer.
}
