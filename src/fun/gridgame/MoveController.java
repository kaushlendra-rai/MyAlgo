package fun.gridgame;

public interface MoveController {
	public void execute(State s, String action) throws Exception;
}
