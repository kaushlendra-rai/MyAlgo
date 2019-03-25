package com.kausha.design.carparking;

public class PaymentReceipt {
	String receiptId;
	String paymentMode; // Cash, card ... We can even capture details of cards if we want to extend
	
	ParkingTicket parkingTicket;
	Double amount;
}
