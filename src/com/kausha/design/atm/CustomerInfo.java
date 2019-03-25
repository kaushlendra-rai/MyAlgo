package com.kausha.design.atm;

public class CustomerInfo {
	String customerName;
	String customerId;
	String bankId;
	double availableBalance;
	String accountType;
	double availableTransactionLimit;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public double getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAvailableTransactionLimit() {
		return availableTransactionLimit;
	}
	public void setAvailableTransactionLimit(double availableTransactionLimit) {
		this.availableTransactionLimit = availableTransactionLimit;
	}
}
