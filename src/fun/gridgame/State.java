package fun.gridgame;

public class State extends TwoDimensionalLocation{

	public static final String M = "M";
	private String direction;
	//private int position_x;
	//private int position_y;
	
	public State(int x,int y,String d)
	{
		super(x,y);
		//position_x = x;
		//position_y = y;
		direction = d;
	}
	
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
/*	public int getPosition_x() {
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
	}*/
	
	public String toString()
	{
		return "position_x = " + getPosition_x() + " , position_y = " + getPosition_y() + " , direction = " + getDirection();
	}
}
