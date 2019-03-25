package com.rai.kaushal.test;

import java.lang.reflect.Method;
import java.net.URLEncoder;

public class SubString {

	public static void main(String[] args) throws Exception{
		String str = "http://localhost:8080/SASSearchService/?forward=authorize*";

		String sub = str.substring(0, str.indexOf("SASSearchService"));
		sub = sub + "SASSearchService/rest/content";
		System.out.println(sub);
		
		System.out.println(URLEncoder.encode("and(matchAny(\"*\"))", "UTF-8"));
		
		SubString subs = new SubString();
		
		Class[] classType = new Class[1];
		classType[0] = String.class;
		
		Method method = subs.getClass().getMethod("getValue", classType);
		
		System.out.println("method.getName() = " + method.getName());
	}
	
	public String getValue(String value){
		return value;
	}

}
