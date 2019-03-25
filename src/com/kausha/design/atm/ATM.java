package com.kausha.design.atm;

public interface ATM {
	boolean withdrawCash(String accountId, int amount);
	double getBalance();
	String getAccountSummary();
}
