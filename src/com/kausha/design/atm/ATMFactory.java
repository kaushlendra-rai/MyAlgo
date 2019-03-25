package com.kausha.design.atm;

public class ATMFactory {

	public static DispensableDenomination getChainedDenominationProcessors(){
		// Perform chaining of Denominations
		DispensableDenomination fifty = new DenominationFifty(null);
		DispensableDenomination hundred = new DenominationHundred(fifty);
		DispensableDenomination fiveHundred = new DenominationFiveHundred(hundred);
		DispensableDenomination twoThousand = new DenominationTwoThousand(fiveHundred);
		
		return twoThousand;
	}
}
