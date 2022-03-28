package com.kausha.design.atm2;

import com.kausha.design.atm2.Command;

public class WithdrawMoneyCommand implements ATMAction {
	BankingService bankingService;
	
	CardInfo cardInfo;
	int amount;
	public WithdrawMoneyCommand(BankingService bankingService, CardInfo cardInfo, int amount) {
		this.cardInfo = cardInfo;
		this.amount = amount;
		this.bankingService = bankingService;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
