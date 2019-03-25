package fun.airline.ticket2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FlightSearchEngine {

	/**
	 * This method is used to search the flight on the basis of
	 *  departure location, arrival location and flight date given
	 *   by the user.
	 * @param from
	 * @param to
	 * @param flightDate
	 * @param sortBy
	 */
	static List<Map<String, String>> searchFlight(String from, String to, String flightDate, String sortBy) throws Exception{
		
		Map<String, List<Map<String, String>>> flightMap = LoadAirlinesData.getAirlinesMap();
		Set<String> airlineName = flightMap.keySet();
		List<Map<String, String>> flNo = new ArrayList<Map<String, String>>();
		String depLoc = null;
		String arrvpLoc = null;
		for(String airline : airlineName){
			List<Map<String, String>> flightForAirlines = flightMap.get(airline);
			for(Map<String, String> flight: flightForAirlines){
				depLoc = flight.get("DEP_LOC");
				arrvpLoc = flight.get("ARR_LOC");
				if(from.equalsIgnoreCase(depLoc)){
					if(to.equalsIgnoreCase(arrvpLoc)){
						if(isFlightvalid(flight, flightDate))
							flNo.add(flight);
					}
				}
			}
			
		}
		
		// Perform sorting
		if("FARE".equalsIgnoreCase(sortBy))
			Collections.sort(flNo, new FareComparator());
		else
			Collections.sort(flNo, new FareAndDurationComparator());
		
		return flNo;
	}
	
	/** This method checks from the flight map weather the 
	 *   user flight date should be less than the flight date
	 * 
	 * @param flt
	 * @param fltDate
	 * @return
	 */
	private static boolean isFlightvalid(Map flt, String fltDate){
		String[] date = ((String)flt.get("VALID_TILL")).split("-");
		String[] userDate = fltDate.split("-");
		Calendar cal1 = new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
		Calendar cal2 = new GregorianCalendar(Integer.parseInt(userDate[2]), Integer.parseInt(userDate[1]), Integer.parseInt(userDate[0]));
		
		if(cal1.getTimeInMillis() >= cal2.getTimeInMillis())
			return true;
		else
			return false;
	}
}