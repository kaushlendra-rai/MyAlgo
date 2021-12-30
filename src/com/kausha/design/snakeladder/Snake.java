package com.kausha.design.snakeladder;

import java.util.Map;

public class Snake extends Transfer implements Mover {

	public Snake(int start, int end) {
		super(start, end);
	}

	@Override
	public void move(SnakeLadderBoard board, Player player) {
		Map<Player, Integer> moves = board.getMoves();
		moves.put(player,  moves.get(player) + getEnd());
	}
}
