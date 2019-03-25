package com.kausha.design.atm;

public class ATMMachine implements ATM{
	
	
	public double getBalance(){
		
		return 0.0;
	}
	
	public String getAccountSummary(){
		
		return null;
	}

	@Override
	public boolean withdrawCash(String accountId, int amount) {
		MoneyWithdrawlRequest withdrawlRequest = new MoneyWithdrawlRequest();
		withdrawlRequest.setPendingMoney(amount);
		
		DispensableDenomination dispensableDenomination = ATMFactory.getChainedDenominationProcessors();
		dispensableDenomination.checkMoneyAvailability(withdrawlRequest);
		
		if(withdrawlRequest.pendingMoney == 0){
			// Requested Cash can be dispensed from the ATM, pull out the respective cash from the CashStore and dispense to teh customer
			dispensableDenomination.dispenseMoney(withdrawlRequest);
			return true;
		}else
			return false;
	}
}
