package fun.gridgame;

public class LRMovesStateController extends LRUDMoveStateController {

	protected void changeDirection(State s, String action) throws Exception{

		//System.out.println("Dir = " + s.getDirection());
		int currentDirection = Integer.parseInt(PropertyLoader.getDirectionValue(s.getDirection()));
		int action_direction = Integer.parseInt(PropertyLoader.getDirectionValue(action));
		int new_direction = (currentDirection + action_direction);
		if(new_direction <0)
			new_direction = new_direction + 4;
		else
			new_direction = new_direction%4;
		
		// Set the new Direction in the state.
		s.setDirection(PropertyLoader.getDirectionValue("" + new_direction));
	}
}
