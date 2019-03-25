package fun.gridgame;

public class LRUDMoveStateController implements MoveController{

	// This method updates the State reference directly.
	public void execute(State s, String action) throws Exception
	{
		if(State.M.equalsIgnoreCase(action))
		{
			// Perform any check/action before you make a move.
			if(preMove(s, action))
				if(makeMove(s))// Actually move if preMove returns true.
					postMove(s, action);
		}
		else
			changeDirection(s, action);
	}

	protected void changeDirection(State s, String action) throws Exception{
		if(PropertyLoader.getValue(action) != null)
			s.setDirection(action);
		else
			throw new Exception("Direction not defined"); // Throw more specific Exception.
	}

	protected boolean makeMove(State s) throws Exception{
		boolean result = true;
		try{
			// First get the co-ordinate move for the current state.
			String[] displacement = PropertyLoader.getValue(s.getDirection()).split(",");
			int position_x = Integer.parseInt(displacement[0]);
			int position_y = Integer.parseInt(displacement[1]);
			
			s.setPosition_x(s.getPosition_x() + position_x);
			s.setPosition_y(s.getPosition_y() + position_y);
		}
		catch(Exception e){
			result = false;
		}
		
		//System.out.println(s);
		return result;
	}

	protected boolean preMove(State s, String action) {
		// TODO Auto-generated method stub
		return true;
	}

	protected void postMove(State s, String action) {
		// TODO Auto-generated method stub
		
	}
}
