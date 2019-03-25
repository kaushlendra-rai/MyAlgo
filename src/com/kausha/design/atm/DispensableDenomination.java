package com.kausha.design.atm;

public interface DispensableDenomination {

	void dispenseMoney(MoneyWithdrawlRequest request);
	
	void checkMoneyAvailability(MoneyWithdrawlRequest request);
}
