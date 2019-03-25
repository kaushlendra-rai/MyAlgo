package com.kausha.design.atm;

public class DenominationTwoThousand implements DispensableDenomination {

	// Here we use Chain Of responsibility' design pattern from Highest Denomination to the Lowest
	// and add whatever is feasible as per the current MoneyWithdrawlRequest
	DispensableDenomination successorProcessDenomination;
	Denominations currentDenomination = Denominations.TWOTHOUSAND;
	
	public DenominationTwoThousand(DispensableDenomination processDenomination){
		successorProcessDenomination = processDenomination;
	}
	
	@Override
	public void checkMoneyAvailability(MoneyWithdrawlRequest request) {
		if(request.pendingMoney >= currentDenomination.value){
			// Process
			
			int currencyCountRequired = request.pendingMoney/currentDenomination.value;
			
			int availableCurrencyCount = CashStore.getInstance().getAvailableCountForDenomination(currentDenomination);
			
			if(availableCurrencyCount > currencyCountRequired){
				request.pendingMoney = request.pendingMoney%currentDenomination.value;
				request.addToCollector(currentDenomination, currencyCountRequired);
			}else{
				request.pendingMoney = request.pendingMoney - currentDenomination.value * availableCurrencyCount;
				request.addToCollector(currentDenomination, availableCurrencyCount);
			}
				
			
			
			// If by this time, the money requested is available in ATM cache, return. We need not proceed further
			if(request.pendingMoney == 0)
				return;
		}
		
		// The last element in chain of responsibility would have an empty successor
		if(successorProcessDenomination != null)
			successorProcessDenomination.dispenseMoney(request);
	}

	// Perform the actual deduction from the CashStore if the required Cash can be dispensed from the ATM
	@Override
	public void dispenseMoney(MoneyWithdrawlRequest request) {
		CashStore.getInstance().withdrawFromStore(currentDenomination, request.getCollection().get(currentDenomination));
	}
}