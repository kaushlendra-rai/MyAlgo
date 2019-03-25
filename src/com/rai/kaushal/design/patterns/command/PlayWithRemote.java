package com.rai.kaushal.design.patterns.command;

public class PlayWithRemote {

	public static void main(String[] args) {
		ElectronicDevice device = DeviceFactory.getDevice("TV");
		
		TurnTVOn onCommand = new TurnTVOn(device);
		onCommand.execute();
		
		TurnTVVolumeUp upCommand = new TurnTVVolumeUp(device);
		upCommand.execute();
		upCommand.execute();
		upCommand.execute();
		
		TurnTVVolumeDown downCommand = new TurnTVVolumeDown(device);
		downCommand.execute();
		downCommand.execute();
		
		TurnTVOff offCommand = new TurnTVOff(device);
		offCommand.execute();

	}
}