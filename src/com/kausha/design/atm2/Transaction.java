package com.kausha.design.atm2;

import java.util.Date;

public class Transaction {
	String transactionID;
	String atmID;
	Date time;
	String cardNumber;
	TransactionType transactionType;
	TransactionStatus status;
}
