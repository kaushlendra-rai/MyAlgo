package fun.gridgame;

public interface Plateau {
	
	public Location getOrigin();
	
	public Location getDiagnoalEnd();
	
	public void setOrigin(Location location);
	
	public void setDiagnoalEnd(Location location);
}
