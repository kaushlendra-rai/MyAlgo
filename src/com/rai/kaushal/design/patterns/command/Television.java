package com.rai.kaushal.design.patterns.command;

public class Television implements ElectronicDevice {

	private int volume;
	
	@Override
	public void on() {
		System.out.println("TV is ON");
	}

	@Override
	public void off() {
		System.out.println("TV is OFF");
	}

	@Override
	public void volumeUp() {
		volume++;
		System.out.println("TV volume UP. volume is: " + volume);
	}

	@Override
	public void volumeDown() {
		volume--;
		System.out.println("TV volume DOWN. volume is: " + volume);
	}

}
