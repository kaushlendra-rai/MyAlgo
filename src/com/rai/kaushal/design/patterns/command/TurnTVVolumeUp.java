package com.rai.kaushal.design.patterns.command;

public class TurnTVVolumeUp implements Command {

	ElectronicDevice device;
	
	public TurnTVVolumeUp(ElectronicDevice device) {
		this.device = device;
	}
	
	@Override
	public void execute() {
		device.volumeUp();
	}
}