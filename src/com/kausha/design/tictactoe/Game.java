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
	// We maintain the grid to ensure that a block once occupied by a player is not again used for a move.
	int[][] grid;

	Player player1;
	Player player2;
	
	// A list of moves can be maintained in case if we intend to help player see their moves in the game at some later point in time.
	// This would require to be persisted along with gameID.
	List<Move> moves;
	
	Player winner;
	
	int[] rowSum;
	int[] columnSum;
	int fwdDiagonalSum;
	int revDiagonalSum;
	
	int totalMoves;
	
	// This should get evaluated with every move.
	GameStatus status;
	
	public Game(int gridSquareSize, Player player1, Player player2) {
		gameID = UUID.randomUUID().toString();
		
		// We use the below move value in evaluating the game winner.
		player1.setMoveValue(1);
		player2.setMoveValue(-1);
		
		this.gridSquareSize = gridSquareSize;
		this.player1 = player1;
		this.player2 = player2;
		this.rowSum = new int[gridSquareSize];
		this.columnSum = new int[gridSquareSize];
		this.grid = new int[gridSquareSize][gridSquareSize];
		status = GameStatus.InProgress;
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
		// Validate move.
		validate(move);
		
		grid[move.getBlock().getY()][move.getBlock().getX()] = move.getPlayer().getMoveValue();
		rowSum[move.getBlock().getY()] += move.getPlayer().getMoveValue();
		columnSum[move.getBlock().getX()] += move.getPlayer().getMoveValue();
		
		// Set for diagonal if and only if the move is on the diagonal path blocks.
		if(move.getBlock().getX() == move.getBlock().getY()) {
			fwdDiagonalSum += move.getPlayer().getMoveValue();
		}
		// Reverse Diagonal
		if(move.getBlock().getX() + move.getBlock().getY() == gridSquareSize + 1) {
			revDiagonalSum += move.getPlayer().getMoveValue();
		}
		
		totalMoves++;
		
		// Check for Rows and columns for win.
		if(Math.abs(rowSum[move.getBlock().getY()]) == gridSquareSize || Math.abs(columnSum[move.getBlock().getX()]) == gridSquareSize ||
				Math.abs(fwdDiagonalSum) == gridSquareSize || Math.abs(revDiagonalSum) == gridSquareSize) {
			winner = move.player;
			status = GameStatus.Winner;
		}
		
		if(totalMoves == gridSquareSize * gridSquareSize)
			status = GameStatus.Draw;
		
		return status;
	}

	private void validate(Move move) throws InvalidMoveException {
		// Ensure that the move specified is within the grid and that the block is not already occupied.
		if(move.getBlock().getY() < 0 || move.getBlock().getY() >= gridSquareSize || move.getBlock().getX() < 0 || move.getBlock().getX() >= gridSquareSize)
			throw new InvalidMoveException("Move outside of grid");
		
		if(grid[move.getBlock().getY()][move.getBlock().getX()] != 0)
			throw new InvalidMoveException("Grid node already occupied.");
		
		if(!status.equals(GameStatus.InProgress))
			throw new InvalidMoveException("Game has already ended.");
	}
}
