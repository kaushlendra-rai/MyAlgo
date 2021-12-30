package com.kausha.design.snakeladder;

import java.util.Map;

public class Ladder extends Transfer implements Mover {

	public Ladder(int start, int end) {
		super(start, end);
	}

	@Override
	public void move(SnakeLadderBoard board, Player player) {
		Map<Player, Integer> moves = board.getMoves();
		moves.put(player,  moves.get(player) + getEnd());
	}
}
