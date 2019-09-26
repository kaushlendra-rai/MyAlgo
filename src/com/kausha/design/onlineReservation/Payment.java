package com.kausha.design.onlineReservation;

import java.util.Date;

public class Payment {
	String orderId;
	String userId;
	PaymentMode paymentMode;
	Date paymentTime;
}

enum PaymentMode{
	CreditCard, Cash, DesbitCard, EWallet;
}