/*package com.kausha.concurrency;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SearchTextInFolderContentTest {

	@Test
	public void testSearchTextInFolder(){
		String path = "C:\\MyPersonal\\TestArea\\src\\com\\sas\\rai\\kaushal\\geeks";
		String expression = "ExecutorService";
		List<String> result = null;
		
		try{
			result = SearchTextInFolderContent_Future.getMatchingText(path, expression);
		}catch(Exception e){
			
		}
		
		assertEquals("Search done", true, result == null);
	}
}*/
