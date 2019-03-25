package com.kausha.design.carparking;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Can use annotation approach, i.e.
 * Create a new annotation say - 'Vehicle' which a field say 'type'.
 * They need to ensure that the classes are are covered in ComponentScan package to ensure that the classes are loaded in memory
 *  
 * @author sinkar
 *
 */
public class VehicleFactory {
	Map<String, Class> vehicleClassMap = new HashMap<String, Class>();
	
	boolean factoryMapLoaded = false;
	
	public Vehicle getVehicle(String vehicleType){
		if(!factoryMapLoaded)
			loadVehicleMap();
		
		Class vehicleClass = (Class)vehicleClassMap.get(vehicleType);
		Vehicle vehicle =  null;
		
		if(vehicleClass != null){
			try{
				Constructor productConstructor = vehicleClass.getDeclaredConstructor(new Class[] { String.class });
				vehicle =  (Vehicle)productConstructor.newInstance(new Object[] { });
			}catch(Exception e){
				System.out.println("Exception while getting Vehicle for type : " + vehicleType);
				throw new RuntimeException("Exception while getting Vehicle for type : " + vehicleType, e);
			}
			
		}else{
			throw new RuntimeException("No class definition found for vehicle type : " + vehicleType);
		}
		
		return vehicle;
	}

	/**
	 * Scan classes & get list of classes Annotated with '@Vehicle' annotation
	 */
	private void loadVehicleMap() {
		
		
	}
}