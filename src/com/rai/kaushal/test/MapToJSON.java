package com.rai.kaushal.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MapToJSON {

	public static void main(String[] args) throws Exception{
		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, List<String>> mapObject = new HashMap<String, List<String>>();
		List<String> l1 = new ArrayList<String>();
		l1.add("Kaushal");
		l1.add("Rai");
		
		
		List<String> l2 = new ArrayList<String>();
		l2.add("Sonu");
		l2.add("Rai");
		
		mapObject.put("name", l1);
		mapObject.put("house", l2);
		

		long start = System.nanoTime();
		byte[] stream = objectMapper.writeValueAsBytes(mapObject);
		System.out.println("Time taken to convert in bytes = " + (System.nanoTime() - start));
		
		start = System.nanoTime();
		String output = objectMapper.writeValueAsString(mapObject);
		System.out.println("Time taken to convert in String = " + (System.nanoTime() - start));
		System.out.println(output);
		
		//=============================================  Convert back to Objects
		Map<String, List<String>> facets = objectMapper.readValue(output, new TypeReference<Map<String, List<String>>>(){});
		System.out.println(facets.keySet());
	}
}