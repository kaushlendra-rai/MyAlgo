package com.rai.kaushal.design.patterns.command;

public class TurnTVOn implements Command {

	ElectronicDevice device;
	
	public TurnTVOn(ElectronicDevice device) {
		this.device = device;
	}
	
	@Override
	public void execute() {
		device.on();
	}
}