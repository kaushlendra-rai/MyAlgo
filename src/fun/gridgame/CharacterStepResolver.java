package fun.gridgame;

import java.util.ArrayList;
import java.util.List;

public class CharacterStepResolver implements StepResolver {

	public List<String> getSteps(String moves) {
		char[] c = moves.toCharArray();
		
		List<String> list = new ArrayList<String>();

		for(char c1 : c)
		{
			if(c1 == ' ')
				continue;
			
			list.add("" + c1);
		}

		return list;
	}

}
