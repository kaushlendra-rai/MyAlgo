package fun.airline.ticket2;

import java.util.List;
import java.util.Map;

public class TestAirlines {

	/**
	 * this is used to test the fligt search engine
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			// in case you can use this data for running without command line args.
			List<Map<String, String>> flNo = FlightSearchEngine.searchFlight("BOS","CDG", "20-11-2009", "fare");

			//List<Map> flNo = engine.searchFlight(args[0],args[1], args[2], args[3]);
			
			if(flNo == null || flNo.size() == 0)
				System.out.println("No Flights found for this route for given date");
			else
				for(Map<String, String> flight: flNo)
					System.out.println("Flight No :"+flight.get("FLIGHT_NUM") + "  ,   From Location :"+flight.get("DEP_LOC")+" ,  To :"+ flight.get("ARR_LOC")+" , Fare :"+ flight.get("FARE")+" , Duration :"+ flight.get("FLIGHT_DURN"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}