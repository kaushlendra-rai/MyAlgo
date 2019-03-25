package fun.atm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class BankATM implements ATM{

	private static Map<Integer, Integer> balanceMap = balanceMap = new TreeMap<Integer, Integer>();
	private static List<Integer> sortedDenominationsList = null;

	public void addDenominationsToATM(Integer denomination, Integer quantity){
		balanceMap.put(denomination, quantity);
	}
	
	public Map<Integer, Integer> withdraw(Integer amount) throws ATMException{
		
		if(sortedDenominationsList == null)
			sortedDenominationsList = getDescendingDenominations();
		Map<Integer, Integer> userBalanceMap = null;
		
		if(calculateATMTotalBalance() >= amount){
			userBalanceMap = validateAndPerformTransaction(amount);
		}else
			throw new ATMException("Not enough funds in ATM. Please try again after some time.");
		
		if(userBalanceMap == null)
		{	//System.out.println("Could not withdraw..");
			throw new ATMException("Could not get the Denominations for current amount. Please try some other amount.");
		}else{
			Set<Integer> keys = userBalanceMap.keySet();
			for(Integer i : keys)
				 System.out.println("Denomination -> " + i + " ,  Qunatity: " + userBalanceMap.get(i));
		}
		return userBalanceMap;
	}
	
	/**
	 * Optimistic check for cases where the ATM runs out of Balance. No processing should be
	 * performed in that case.
	 * @return
	 */
	private int calculateATMTotalBalance(){
		int totalAmount = 0;
		
		for(Integer deno : sortedDenominationsList){
			totalAmount += deno * balanceMap.get(deno);
		}
		
		return totalAmount;
	}
	
	private synchronized Map<Integer, Integer> validateAndPerformTransaction(int amount){
		Map<Integer, Integer> userBalanceMap = new HashMap<Integer, Integer>();
		
		for(Integer denomination : sortedDenominationsList){
			int denoCount = amount/denomination;
			
			if(denoCount > 0){
				int currentDenoCountInMap = balanceMap.get(denomination);
				
				if(currentDenoCountInMap >= denoCount){
					userBalanceMap.put(denomination, denoCount);
					amount = amount - denomination*denoCount;
				}else{
					userBalanceMap.put(denomination, currentDenoCountInMap);
					amount = amount - denomination*currentDenoCountInMap;
				}
			}
		}
		
		// ATM has the sufficient denominations of currency for dispensing the amount to the user.
		// Perform the transaction.
		if(amount == 0){
			Set<Integer> keys = userBalanceMap.keySet();
			for(Integer denomination : keys){
				//System.out.println("User Balance :: " + userBalanceMap.get(denomination));
				balanceMap.put(denomination, balanceMap.get(denomination) - userBalanceMap.get(denomination));
			}
		}
		else
			userBalanceMap = null;
		
		return userBalanceMap;
	}
	
	private List<Integer> getDescendingDenominations(){
		Set<Integer> keys = balanceMap.keySet();
		 
		 List<Integer> denominations = new ArrayList<Integer>();
		 
		 for(Integer i : keys)
			 denominations.add(i);
		
		 Collections.reverse(denominations);
		 
		 return denominations;
	}
}
