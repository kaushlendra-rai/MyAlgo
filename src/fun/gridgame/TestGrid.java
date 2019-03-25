package fun.gridgame;

import java.util.List;

public class TestGrid {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// Load the defined moves.
		PropertyLoader.load();

		//String moves = "LMLMLMLMM";
		String moves = "MMRMMRMRRM";
		State state = init();
		
		StepResolver stepResolver = (StepResolver)ClassLoaderFactory.loadClass("StepResolver"); 
		List<String> steps = stepResolver.getSteps(moves);
		
		MoveController sc = (MoveController)ClassLoaderFactory.loadClass("MoveController");;
		for(String s : steps)
			sc.execute(state, s);
		
		System.out.println("Direction : " + state.getDirection() + "  ,  X = " + state.getPosition_x() + "  , Y = " + state.getPosition_y());
	}
	
	private static State init()
	{
		int default_position_x = 3;
		int default_position_y = 3;
		String default_direction = "E";
		
		/*int default_position_x = 1;
		int default_position_y = 2;
		String default_direction = "N";*/
		
		return  new State(default_position_x, default_position_y, default_direction);
	}
}