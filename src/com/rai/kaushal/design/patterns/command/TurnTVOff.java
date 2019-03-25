package com.rai.kaushal.design.patterns.command;

public class TurnTVOff implements Command {

	ElectronicDevice device;
	
	public TurnTVOff(ElectronicDevice device) {
		this.device = device;
	}
	
	@Override
	public void execute() {
		device.off();
	}
}