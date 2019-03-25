package com.rai.kaushal.design.patterns.command;

public class DeviceFactory {

	public static ElectronicDevice getDevice(String deviceName){
		if("TV".equals(deviceName))
			return new Television();
		else
			return null;
	}
}
