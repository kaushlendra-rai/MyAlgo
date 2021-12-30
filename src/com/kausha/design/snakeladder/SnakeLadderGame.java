package com.kausha.design.snakeladder;

import java.util.Map;

public class SnakeLadderGame {
	private SnakeLadderBoard board;
	private boolean gameEnded;
	private Player winningPlayer;
	
	public void initializeBoard(SnakeLadderBoard board) {
		this.board = board;
	}
	
	public void move(Player player) {
		int steps = Dice.roll();
		if(valid(player, steps)) {
			Map<Player, Integer> moves = board.getMoves();
			int position = moves.get(player);
			
			board.getTransfer().getOrDefault(position + steps,new Transfer()).move(board, player);
			if(position + steps == board.getSize()) {
				gameEnded = true;
				winningPlayer = player;
				System.out.println("Player: " + player.getId() + " with name: " + player.getName() + " has won the game.");
			}
			moves.put(player, position + steps);
		}
	}

	// All logic of if a player can start from '0' only if he gets '1' or '6' should be added here.
	// Also, if user exceeds '100', move not allowed should be checked.
	// If a game has ended, moves should be ignored.
	// Better return different error codes to indicate the actual situation.
	private boolean valid(Player player, int steps) {
		
		return false;
	}

	public SnakeLadderBoard getBoard() {
		return board;
	}

	public boolean isGameEnded() {
		return gameEnded;
	}

	public Player getWinningPlayer() {
		return winningPlayer;
	}
}
