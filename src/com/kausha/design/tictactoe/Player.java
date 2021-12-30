package com.kausha.design.tictactoe;

public class Player {

	String id;
	String name;
	
	// Value '1'for Player1 & '-1'for player 2
	int moveValue;
	
	public void setMoveValue(int moveValue) {
		this.moveValue = moveValue;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getMoveValue() {
		return moveValue;
	}
	// Profile related other details could be added.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
