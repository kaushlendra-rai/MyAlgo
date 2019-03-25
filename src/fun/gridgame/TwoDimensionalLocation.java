package fun.gridgame;

public class TwoDimensionalLocation implements Location{

	private int position_x;
	private int position_y;
	private boolean occupied;
	
	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public TwoDimensionalLocation(int x, int y)
	{
		position_x = x;
		position_y = y;
	}
	
	public int getPosition_x() {
		return position_x;
	}
	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}
	public int getPosition_y() {
		return position_y;
	}
	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
	
}
