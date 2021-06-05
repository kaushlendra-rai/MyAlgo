package com.kausha.design.atm2;

import java.util.Map;

/**
 * Here an optimized strategy is used for dispensing the amount. May be, here the ATM might use
 * the currency of higher denominations along with some mix of lower denominations for optimal value
 * for bank's ATM and customer.
 * @author sinkar
 *
 */
public class DefaultDispenserStrategy implements DispenserStrategy {

	@Override
	public Map<Denomination, Integer> dispenseCash(int amount, Map<Denomination, Integer> cashStore) {
		
		return null;
	}

}
