package com.kausha.design.tictactoe;

public class Move {
	BoardBlock block;
	Player player;
	
	public Move(BoardBlock block, Player player) {
		super();
		this.block = block;
		this.player = player;
	}

	public BoardBlock getBlock() {
		return block;
	}

	public Player getPlayer() {
		return player;
	}
	
}
