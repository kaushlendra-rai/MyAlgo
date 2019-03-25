package com.kausha.design.atm;

import java.util.HashMap;
import java.util.Map;

public class CashStore {
	
	private CashStore(){
		
	}

	private static CashStore cashStore = new CashStore();
	
	public static CashStore getInstance(){
		return cashStore;
	}
	
	Map<Denominations, Integer> collection = new HashMap<Denominations, Integer>();
	
	public Integer getAvailableCountForDenomination(Denominations denomination){
		return collection.get(denomination);
	}
	
	public void addToCashStore(Denominations denomination, Integer count){
		if(count<0)
			throw new RuntimeException("Negative currency count cannot be added. Count = " + count);
		
		Integer availableCount = collection.getOrDefault(denomination, 0);
		collection.put(denomination, availableCount + count);
	}
	
	public void withdrawFromStore(Denominations denomination, int count){
		if(count<0)
			throw new RuntimeException("Negative currency count cannot be added. Count = " + count);
		else if(count == 0)
			return;
		
		Integer availableCount = collection.getOrDefault(denomination, 0);
		
		if(count > availableCount)
			throw new RuntimeException("Cannot withdraw more than what is available");
		
		collection.put(denomination, availableCount - count);
	}
}
