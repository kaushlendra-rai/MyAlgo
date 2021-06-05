package com.kausha.design.tictactoe;

public class BoardBlock {
	int x;
	int y;
	Player player;

	public BoardBlock(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
