package com.kausha.design.atm2;

import java.util.HashMap;
import java.util.Map;

public class CashDispenser {

	Map<Denomination, Integer> cashStore= new HashMap<>();
	// Mostly any extra dependencies required for dispensing cash would be handled in this CashDispenser.
	// For example, verifying the access to Cash-Store
	// Any other dependency on other service, etc.
	private DispenserStrategy strategy;
	
	public void setDispensingStrategy(DispenserStrategy strategy) {
		this.strategy = strategy;
	}
	
	// The dispense method uses strategy to decide which denominations of currencies need to be dispensed
	// and their quantity based on available cashStore. Then we settle the amount from cash store and dispense cash. 
	public Map<Denomination, Integer> dispense(int amount){
		Map<Denomination, Integer> cash = strategy.dispenseCash(amount, cashStore);
		
		// settle the above proposed cash with cashStore and then release funds.
		settleCash(cash);
		return cash;
	}

	// Deduct the cash from the 'cashStore' as a part of cash withdrawl.
	private void settleCash(Map<Denomination, Integer> cash) {
		
		
	}
	
	// Load cash into ATM's cash-store. It will have currencies of different denominations and quantity.
	public boolean loadCash(Map<Denomination, Integer> cash) {
		return true;
	}
}
