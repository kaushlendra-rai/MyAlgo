package fun.airline.ticket2;

import java.util.Comparator;
import java.util.Map;

/**
 * This class is used as a comparator for Fare and Duration
 * @author Amit
 *
 */
public class FareAndDurationComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {
		int fare1 = Integer.parseInt((String)((Map)arg0).get("FARE"));
		int fare2 = Integer.parseInt((String)((Map)arg1).get("FARE"));
		double duration1 = Double.parseDouble((String)((Map)arg0).get("FLIGHT_DURN"));
		double duration2 = Double.parseDouble((String)((Map)arg1).get("FLIGHT_DURN"));
		
		if(fare1-fare2 == 0){
			return (int) ((duration1 - duration2)*100);
		}
		else
			return fare1-fare2;
	}
}