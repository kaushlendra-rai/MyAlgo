package com.rai.kaushal.test;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class BasicTest{
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
//		UNCHAHAR JN - UCR
		System.out.println(Locale.SIMPLIFIED_CHINESE.toString());
		Date date = new Date();
		date.setYear(1937);
		date.setMonth(11);
		System.out.println(date);
		System.out.println(date.getTime());
		
		System.out.println(new Date().getTime());
		System.out.println(System.currentTimeMillis());
		
		
		Date date2 = (Date) null;
		
		
		
  }
	
	private static List<String> getMatchingWordsList(String matchTextLines, String startTag, String endTag) {
		// We know that the matching fields would be surrounded by startTag & endTag as specified in the queryData
		List<String> matches = new ArrayList<String>();
		
		int endIndex = 0;
		int startIndex = 0;
		int initialGap = 0;
		
		while(matchTextLines.indexOf(startTag, endIndex + initialGap) >= 0){
			startIndex = matchTextLines.indexOf(startTag, endIndex+initialGap);
			endIndex = matchTextLines.indexOf(endTag, startIndex + startTag.length());
			initialGap = endTag.length();
			System.out.println("startIndex = " + startIndex);
			System.out.println("endIndex = " + endIndex);
			matches.add(matchTextLines.substring(startIndex + startTag.length(),endIndex));
		}
		
		System.out.println(matches);
		return matches;
	}
}