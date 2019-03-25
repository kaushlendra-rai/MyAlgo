package com.rai.kaushal.design.patterns.command;

public class DeviceButton {

	Command command;
	
	public DeviceButton(Command command){
		this.command = command;
	}
	
	public void pressButton(){
		command.execute();
	}
}