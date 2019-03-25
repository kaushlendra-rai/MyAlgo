package com.kausha.design.chess;

public interface MoveStrategy {
	boolean isMoveValid(Player player, Block from, Block to) throws InvalidMoveException;
	
	// If the move ensures that the King has been killed, return true inferring that the current move secured win
	boolean move(Player player, Block from, Block to);
}
