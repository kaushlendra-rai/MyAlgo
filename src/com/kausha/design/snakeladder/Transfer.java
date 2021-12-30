package com.kausha.design.snakeladder;

public class Transfer implements Mover{
	private int start;
	private int end;
	public Transfer() {
		
	}
	public Transfer(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	@Override
	public void move(SnakeLadderBoard board, Player player) {
		// Do nothing
	}
}
