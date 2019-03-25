package com.kausha.design.atm;

public class AccountBalanceCommand implements Command {

	CustomerInfoDAO customerInfoDAO;
	
	CustomerInfo customerInfo;
	String customerId;
	
	public AccountBalanceCommand(CustomerInfoDAO customerInfoDAO, String customerId, CustomerInfo customerInfo){
		this.customerInfoDAO = customerInfoDAO;
		this.customerId = customerId;
		this.customerInfo = customerInfo;
	}
	
	@Override
	public void execute() {
		customerInfo.setAvailableBalance(customerInfoDAO.getAvailableBalance(customerId));
	}
}