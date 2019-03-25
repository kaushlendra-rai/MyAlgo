package fun.airline.ticket2;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LoadAirlinesData {
	private static Map<String, String> initData = new HashMap<String, String>();
	
	private static Map<String, List<Map<String, String>>> airlinesMap = new HashMap<String, List<Map<String, String>>>();
	
	/**
	 * please specify the source flight data file here. 
	 *
	 */
	private static void setDataFiles(){
		//initData.put("AIR FRANCE", MyConstants.BASE_PROPERTY_PATH + "txt/AIR_FRANCE.txt");
		//initData.put("LUFTHANSA AIRLINES", MyConstants.BASE_PROPERTY_PATH + "txt/LUFTHANSA_AIRLINES.txt");
		//initData.put("BRITISH AIRWAYS", MyConstants.BASE_PROPERTY_PATH + "txt/BRITISH_AIRWAYS.txt");
	}
	
	/**
	 * this method is used to initializes the flight 
	 *  data from flat files to Map
	 * @throws Exception
	 */
	private static void initialize() throws Exception{
		setDataFiles();
		
		Set<String> keys = initData.keySet();
		for(String airlines : keys){
			// read data from files
			List<Map<String, String>> flightForAirlines = new ArrayList<Map<String, String>>(); 
			Scanner scan = new Scanner(new File((String)initData.get(airlines)));

			while(scan.hasNextLine())
				flightForAirlines.add(processData(scan.nextLine()));
			
			airlinesMap.put(airlines, flightForAirlines);
		}
	}
	
	/**
	 * Categorize data from flat files
	 * 
	 * @param fileLine
	 * @return
	 */
	private static Map<String, String> processData(String fileLine){
		String[] lineElements = fileLine.split("\\|");
		Map<String, String> flightData = new HashMap<String, String>();
		flightData.put("FLIGHT_NUM", lineElements[0]);
		flightData.put("DEP_LOC", lineElements[1]);
		flightData.put("ARR_LOC", lineElements[2]);
		flightData.put("VALID_TILL", lineElements[3]);
		flightData.put("FLIGHT_TIME", lineElements[4]);
		flightData.put("FLIGHT_DURN", lineElements[5]);
		flightData.put("FARE", lineElements[6]);
		
		return flightData;
	}

	public static Map<String, List<Map<String, String>>> getAirlinesMap() throws Exception{
		if(airlinesMap.size() == 0)
			initialize();
		
		return airlinesMap;
	}
}