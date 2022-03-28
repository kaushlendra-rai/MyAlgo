package com.kausha.design.atm2;

public interface BankingService {
	boolean isAuthenticated(CardInfo cardInfo, int[] pin);
	CustomerInfo getCustomerInfo(CardInfo cardInfo);
	Transaction withdraw(CardInfo cardInfo, int amount);
	Transaction submit(CardInfo cardInfo, int amount);
}
