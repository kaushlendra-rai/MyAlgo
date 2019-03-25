package fun.airline.ticket2;

import java.util.Comparator;
import java.util.Map;

/**
 * This class is used as a comparatot for Fare
 * @author Amit
 *
 */
public class FareComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {
		int fare1 = Integer.parseInt((String)((Map)arg0).get("FARE"));
		int fare2 = Integer.parseInt((String)((Map)arg1).get("FARE"));
		
		return fare1-fare2;
	}

}
