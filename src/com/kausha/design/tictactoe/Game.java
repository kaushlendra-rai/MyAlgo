package com.kausha.design.tictactoe;

import java.util.List;
import java.util.UUID;

/**
 * This game has 'move()' & 'getWinner()' method operation performed in O(1)
 * For this we had to add some extra space of O(4gridSquareSize)
 * @author sinkar
 *
 */
public class Game {
	// Each game is unique for reference. 
	String gameID;
	
	int gridSquareSize; 
	Board board;
	Player player1;
	Player player2;
	List<Move> moves;
	Player winner;
	
	int[] rowSum;
	int[] columnSum;
	int[] fwdDiagonalSum;
	int[] revDiagonalSum;
	
	// This should get evaluated with every move.
	boolean gameStatus;
	
	public Game(int gridSquareSize, Player player1, Player player2) {
		gameID = UUID.randomUUID().toString();
		
		// We use the below move value in evaluating the game winner.
		player1.setMoveValue(1);
		player2.setMoveValue(-1);
		
		this.gridSquareSize = gridSquareSize;
		this.player1 = player1;
		this.player2 = player2;
		this.board = new Board(gridSquareSize);
		this.rowSum = new int[gridSquareSize];
		this.columnSum = new int[gridSquareSize];
		this.fwdDiagonalSum = new int[gridSquareSize];
		this.revDiagonalSum = new int[gridSquareSize];
	 }
	 
	 public Player getNextMovePlayer() {
		 return null;
	 }
	 
	 public List<Move> getMoves(){
		 return moves;
	 }
	 
	 public Player getWinner() {
		 return winner;
	 }
	 
	public String getGameID() {
		return gameID;
	}
	
	/**
	 * It MUST be noted that a player can win only when he/she makes a move. Hence game's status should be evaluated
	 * while the players are making move and not at the end of the game.
	 * @param move
	 * @return
	 * @throws InvalidMoveException
	 */
	public GameStatus move(Move move) throws InvalidMoveException{
		// Validate move. Check for boundary conditions and that if the block is not already occupied.
		// Not doing it here for now.
		
		rowSum[move.getBlock().getY()] += move.getPlayer().getMoveValue();
		columnSum[move.getBlock().getX()] += move.getPlayer().getMoveValue();
		GameStatus status = GameStatus.InProgress;
		// Set for diagonal if and only if the move is on the diagonal path blocks.
		// Not doing it for now.
		
		if(rowSum[move.getBlock().getY()] == gridSquareSize || columnSum[move.getBlock().getX()] == gridSquareSize) {
			// Check for diagonals too
			winner = move.player;
			status = GameStatus.Winner;
		}
		
		return status;
	}
}
