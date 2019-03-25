package com.kausha.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MergeRangeList {
	public static void main(String[] args) {
		List<Range> rangeList = new ArrayList<Range>();
		
		populateList(rangeList);
		
		for(Range range : rangeList)
			System.out.println(range);
		
		mergeRangeBoundaries(rangeList);
		
		System.out.println("\n\n Merged Boundaries: \n");
		for(Range range : rangeList)
			System.out.println(range);
	}

	private static void mergeRangeBoundaries(List<Range> rangeList) {
		if(rangeList == null || rangeList.size() < 2)
			return;
		
		// Sort the range list
		Collections.sort(rangeList);
		
		Iterator<Range> rangeIterator = rangeList.iterator();
		Range range = rangeIterator.next();
		int end = range.getEnd();
		
		while(rangeIterator.hasNext()){
			Range tempRange = rangeIterator.next();
			if(tempRange.getStart() <= end){
				if(tempRange.getEnd() < end){
					rangeIterator.remove();
				}else{
					range.setEnd(tempRange.getEnd());
					rangeIterator.remove();
				}
			}else{
				end = tempRange.getEnd();
				range = tempRange;
			}
		}
	}

	private static void populateList(List<Range> rangeList) {
		Range range1 = new Range(1, 5);
		Range range6 = new Range(31, 45);
		Range range3 = new Range(9, 12);
		Range range5 = new Range(25, 35);
		Range range4 = new Range(14, 20);
		Range range7 = new Range(51, 55);
		Range range2 = new Range(7, 15);
		
		/*
		Range range1 = new Range(1, 5);
		Range range2 = new Range(7, 15);
		Range range3 = new Range(9, 12);
		Range range4 = new Range(14, 20);
		Range range5 = new Range(25, 35);
		Range range6 = new Range(31, 45);
		Range range7 = new Range(51, 55);*/
		
		rangeList.add(range1);
		rangeList.add(range2);
		rangeList.add(range3);
		rangeList.add(range4);
		rangeList.add(range5);
		rangeList.add(range6);
		rangeList.add(range7);
	}
}

class Range implements Comparable{
	private int start;
	private int end;
	
	public Range(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	@Override
	public int compareTo(Object o){
		if(o == null || !(o instanceof Range))
			throw new RuntimeException("Invalid parameter");
		
		return start - ((Range)o).getStart();
	}
	
	public String toString(){
		return start + " - " + end;
	}
}