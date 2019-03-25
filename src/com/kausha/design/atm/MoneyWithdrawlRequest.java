package com.kausha.design.atm;

import java.util.HashMap;
import java.util.Map;

public class MoneyWithdrawlRequest {
	int requestedMoney;
	int pendingMoney;
	
	Map<Denominations, Integer> collection = new HashMap<Denominations, Integer>();

	public int getRequestedMoney() {
		return requestedMoney;
	}

	public void setRequestedMoney(int requestedMoney) {
		this.requestedMoney = requestedMoney;
	}

	public int getPendingMoney() {
		return pendingMoney;
	}

	public void setPendingMoney(int pendingMoney) {
		this.pendingMoney = pendingMoney;
	}

	public Map<Denominations, Integer> getCollection() {
		return collection;
	}

	public void addToCollector(Denominations denomination, int count) {
		collection.put(denomination, count);
	}
}