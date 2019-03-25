package fun.atm;

import java.util.Map;

public interface ATM {

	public void addDenominationsToATM(Integer denomination, Integer quantity);
	
	public Map<Integer, Integer> withdraw(Integer amount)  throws ATMException;
}
