package fun.gridgame;

public class TwoDimensionalPlateau implements Plateau {

	private TwoDimensionalLocation origin;
	private TwoDimensionalLocation diagonalEnd;
	
	public Location getDiagnoalEnd() {
		return diagonalEnd;
	}

	public Location getOrigin() {
		return origin;
	}

	public void setDiagnoalEnd(Location location) {
		diagonalEnd = (TwoDimensionalLocation)location;
	}

	public void setOrigin(Location location) {
		origin = (TwoDimensionalLocation)location;
	}
}
