package com.kausha.design.atm2;

import java.util.List;

public class ATM {

	String atmID;
	Address address;
	
	Keypad keypad;
	DisplayScreen screen;
	CardReader cardReader;
	CashDispenser cashDispenser;
	
	List<Button> commandButtons;
	
	// Based on the configured bank, get the Banking service from the Factory.
	// An ATM is independent of the underlying Banking operations.
	BankingService bankingService;
}
