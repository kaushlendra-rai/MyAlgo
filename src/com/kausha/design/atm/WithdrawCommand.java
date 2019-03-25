package com.kausha.design.atm;

public class WithdrawCommand implements Command{

	ATM atm = null;
	String accountId;
	int amount;
	
	public WithdrawCommand(ATM atm, String accountId, int amount){
		this.atm = atm;
		this.accountId = accountId;
		this.amount = amount;
	}
	
	@Override
	public void execute() {
		atm.withdrawCash(accountId, amount);
	}

}
