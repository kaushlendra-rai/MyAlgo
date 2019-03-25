package com.rai.kaushal.test;

public class TestSingletonFieldsAccess {

	public static void main(String[] args) {
		
		SingletonFieldsAccess instance = SingletonFieldsAccess.getInstance();
		instance.printValues();
	}

}
