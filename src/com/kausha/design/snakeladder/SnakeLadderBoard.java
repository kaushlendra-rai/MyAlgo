package com.kausha.design.snakeladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeLadderBoard {
	private int size;
	private Map<Player, Integer> moves;
	
	// The snake & ladder Map has the 'start' value as key.
	private Map<Integer, Transfer> transfer;
	
	public SnakeLadderBoard(int size, List<Player> players, List<Snake> snakes, List<Ladder> ladders) {
		this.size = size;
		// Put all players at the start of the board.
		moves = new HashMap<>();
		for(Player player : players)
			moves.put(player, 0);
		transfer = new HashMap<>();
		
		for(Snake snake: snakes)
			transfer.put(snake.getStart(), snake);
		for(Ladder ladder : ladders)
			transfer.put(ladder.getStart(), ladder);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Map<Player, Integer> getMoves() {
		return moves;
	}

	public void setMoves(Map<Player, Integer> moves) {
		this.moves = moves;
	}

	public Map<Integer, Transfer> getTransfer() {
		return transfer;
	}

	public void setTransfer(Map<Integer, Transfer> transfer) {
		this.transfer = transfer;
	}

}
