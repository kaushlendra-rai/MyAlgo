package com.rai.kaushal.design.patterns.command;

public class TurnTVVolumeDown implements Command {

	ElectronicDevice device;
	
	public TurnTVVolumeDown(ElectronicDevice device) {
		this.device = device;
	}
	
	@Override
	public void execute() {
		device.volumeDown();
	}
}