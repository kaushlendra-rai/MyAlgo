package com.rai.kaushal.test;

import java.util.ArrayList;
import java.util.List;

public class SingletonFieldsAccess {

	private Boolean flag = Boolean.FALSE;
	private List<String> list = new ArrayList<String>();
	
	private static volatile boolean myFlag = false;
	private static List<String> list1 = new ArrayList<String>();
	private static SingletonFieldsAccess sfa = new SingletonFieldsAccess();
	static{
		System.out.println("In static block");
		
		/*list1 = new ArrayList<String>();
		list1.add("Rai");*/
	}
	
	private SingletonFieldsAccess(){
		list.add("Kaushal");
		myFlag = true;
		flag = Boolean.TRUE;
		
		list1.add("Sonu");
	}
	
	public static SingletonFieldsAccess getInstance(){
		return sfa;
	}
	
	public void printValues(){
		System.out.println("flag = " + flag);
		System.out.println("list = " + list);
		System.out.println("myFlag = " + myFlag);
		System.out.println("list1 = " + list1);
	}
}
