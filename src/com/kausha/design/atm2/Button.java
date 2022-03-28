package com.kausha.design.atm2;

public class Button {
	String id;
	String displayText;
	Command command;
	
	public Button(String id, String displayText, Command command) {
		this.id = id;
		this.displayText = displayText;
		this.command = command;
	}
	
	public String getId() {
		return id;
	}
	
	public String getDisplayText() {
		return displayText;
	}
	
	public void onClick() {
		command.execute(this);
	}
}
