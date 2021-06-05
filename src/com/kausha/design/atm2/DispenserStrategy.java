package com.kausha.design.atm2;

import java.util.Map;

public interface DispenserStrategy {
	public Map<Denomination, Integer> dispenseCash(int amount, Map<Denomination, Integer> cashStore);
}
