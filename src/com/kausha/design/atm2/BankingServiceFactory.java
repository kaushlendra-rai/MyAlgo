package com.kausha.design.atm2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BankingServiceFactory {
	// The service will get the 'bankingServiceClassName' from some configuration.
	public BankingService getBankingService(String bankingServiceClassName) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = Class.forName(bankingServiceClassName);
		Constructor<?> ctor = clazz.getConstructor(String.class);
		Object object = ctor.newInstance(bankingServiceClassName);
		
		return (BankingService)object;
	}
}
