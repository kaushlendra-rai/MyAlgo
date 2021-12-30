package com.kausha.design.snakeladder;

import java.util.UUID;

public class Player{
	private String id;
	private String name;
	private int currentPosition;
	
	public Player(String name) {
		id = UUID.randomUUID().toString();
		this.name = name;
	}
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj instanceof Player) {
			Player player = (Player)obj;
			if(this.id == player.getId())
				return true;
		}
		
		return false;
	}
}
