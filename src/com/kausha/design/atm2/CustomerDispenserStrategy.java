package com.kausha.design.atm2;

import java.util.Map;

/**
 * Here the dispensing strategy is decided by the customer.
 * Customer can choose the denominations of currency he/she needs for a given amount.
 * If available, the dispenser will dispense it else throw Exception
 * @author sinkar
 *
 */
public class CustomerDispenserStrategy implements DispenserStrategy {

	@Override
	public Map<Denomination, Integer> dispenseCash(int amount, Map<Denomination, Integer> cashStore) {
		// TODO Auto-generated method stub
		return null;
	}

}
